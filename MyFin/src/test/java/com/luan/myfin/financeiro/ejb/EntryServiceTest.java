package com.luan.myfin.financeiro.ejb;

import com.luan.myfin.base.enums.EntryType;
import com.luan.myfin.base.interfaces.EntryService;
import com.luan.myfin.base.models.Entry;
import com.luan.myfin.ejb.daos.DatabaseInitializer;
import com.luan.myfin.ejb.daos.EntryDAO;
import com.luan.myfin.ejb.services.EntryServiceBean;
import com.luan.myfin.web.resources.App;
import com.luan.myfin.web.resources.EntryResource;
import java.io.File;
import java.sql.Date;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EntryServiceTest {

    Client client;
    WebTarget target;

    @Deployment
    public static Archive createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class, "IntegrationTest.war");
        //Carrega as dependecias do maven para serem usadas nos testes
        File[] files = Maven
                .resolver()
                .loadPomFromFile("pom.xml")
                .importRuntimeDependencies()
                .resolve()
                .withTransitivity()
                .asFile();

        //adiciona as classes que serão deployadas
        archive.addClasses(
                EntryType.class,
                EntryService.class,
                Entry.class,
                DatabaseInitializer.class,
                EntryDAO.class,
                EntryServiceBean.class,
                App.class,
                EntryResource.class,
                EntryServiceTest.class
        );

        //adiciona o modolo do database
        archive.addAsResource("modules/com/h2database/h2/main/module.xml");

        //adiciona a configuração do datasource
        archive.addAsResource("project-defaults.yml");

        //cria o arquivo de bean para que o CDI funcione
        archive.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

        //adiciona as dependencias do maven
        archive.addAsLibraries(files);

        System.out.println("\n\n");
        System.out.println(archive.toString(true));
        System.out.println("\n\n");
        return archive;
    }

    @Before
    public void before() {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/webapi/entry");
    }

    @Test
    public void test_that_the_test_works() {
        assertTrue(true);
    }

    @Test
    @RunAsClient
    public void it_should_gets_all_entries() {

        try {
            List<Entry> entries = target
                    .request()
                    .get(new GenericType<List<Entry>>() {
                    });

            assertEquals(30, entries.size());
            assertEquals("Teste 1", entries.get(0).getDescription());
            assertEquals(120.0d, entries.get(0).getValue(), 0.0001);
            assertEquals(new Date(1509494400000l), entries.get(0).getDate());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @RunAsClient
    public void it_should_insert_entry() {
        Entry entry = new Entry();
        entry.setDescription("Big lanção");
        entry.setType(EntryType.ALIMENTACAO);
        entry.setValue(50.0d);
        entry.setDate(new Date(1509494400000l));

        try {
            Entity<Entry> entity = Entity.entity(entry, MediaType.APPLICATION_JSON);
            Response reponse = target
                    .request()
                    .header("Content-Type", "application/json")
                    .accept(MediaType.APPLICATION_JSON)
                    .post(entity, Response.class);

            String location = reponse.getHeaderString("Location");
            assertEquals(201, reponse.getStatus());
            assertTrue(location.contains("entry/31"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @RunAsClient
    public void it_should_filters_by_description() {
        try {
            List<Entry> entries = target
                    .queryParam("description", " 4")
                    .request()
                    .get(new GenericType<List<Entry>>() {});

            assertEquals(1, entries.size());
            assertEquals("Teste 4", entries.get(0).getDescription());
            assertEquals(200.0d, entries.get(0).getValue(), 0.0001);
            assertEquals(new Date(1509753600000l), entries.get(0).getDate());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    @RunAsClient
    public void it_should_filters_by_type() {
        try {
            List<Entry> entries = target
                    .queryParam("type", "SAUDE")
                    .request()
                    .get(new GenericType<List<Entry>>() {});

            assertEquals(3, entries.size());
            assertEquals("Teste 11", entries.get(0).getDescription());
            assertEquals(500.0d, entries.get(0).getValue(), 0.0001);
            assertEquals(new Date(1510358400000l), entries.get(0).getDate());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}

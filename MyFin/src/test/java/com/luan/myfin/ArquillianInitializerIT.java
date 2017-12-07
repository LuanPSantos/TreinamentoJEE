package com.luan.myfin;

import com.luan.myfin.financeiro.base.enums.EntryType;
import com.luan.myfin.financeiro.base.interfaces.EntryService;
import com.luan.myfin.financeiro.base.models.Entry;
import com.luan.myfin.financeiro.base.models.ViolationException;
import com.luan.myfin.financeiro.ejb.EntryResourceIntegrationTest;
import com.luan.myfin.financeiro.ejb.daos.DatabaseInitializer;
import com.luan.myfin.financeiro.ejb.daos.EntryDAO;
import com.luan.myfin.financeiro.ejb.services.EntryServiceBean;
import com.luan.myfin.financeiro.web.exceptions.ViolationExceptionMapper;
import com.luan.myfin.financeiro.web.resources.App;
import com.luan.myfin.financeiro.web.resources.EntryResource;
import java.io.File;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ArquillianInitializerIT {

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
        archive.addClasses(EntryType.class,
                EntryService.class,
                Entry.class,
                DatabaseInitializer.class,
                EntryDAO.class,
                EntryServiceBean.class,
                App.class,
                EntryResource.class,
                EntryResourceIntegrationTest.class,
                ArquillianInitializerIT.class,
                ViolationException.class,
                ViolationExceptionMapper.class
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
}

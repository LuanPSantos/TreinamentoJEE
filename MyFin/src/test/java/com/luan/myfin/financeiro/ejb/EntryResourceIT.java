package com.luan.myfin.financeiro.ejb;

import com.luan.myfin.financeiro.base.enums.EntryType;
import com.luan.myfin.financeiro.base.models.Entry;
import java.sql.Date;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EntryResourceIT {

    Client client;
    WebTarget target;

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
            assertEquals(new Date(1509494400000L), entries.get(0).getDate());
        } catch (Exception e) {
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
            assertEquals(EntryType.ALIMENTACAO, entry.getType());
        } catch (Exception e) {
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
                    .get(new GenericType<List<Entry>>() {
                    });

            assertEquals(1, entries.size());
            assertEquals("Teste 4", entries.get(0).getDescription());
            assertEquals(200.0d, entries.get(0).getValue(), 0.0001);
            assertEquals(new Date(1509753600000L), entries.get(0).getDate());
            assertEquals(EntryType.MORADIA, entries.get(0).getType());
        } catch (Exception e) {
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
                    .get(new GenericType<List<Entry>>() {
                    });

            assertEquals(3, entries.size());
            assertEquals("Teste 11", entries.get(0).getDescription());
            assertEquals(500.0d, entries.get(0).getValue(), 0.0001);
            assertEquals(new Date(1510358400000L), entries.get(0).getDate());
            assertEquals(EntryType.SAUDE, entries.get(0).getType());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    @RunAsClient
    public void it_should_gets_entrys_until_the_final_period() {
        try {
            List<Entry> entries = target
                    .queryParam("finalPeriod", "2017-11-10")
                    .request()
                    .get(new GenericType<List<Entry>>() {
                    });

            assertEquals(10, entries.size());
            assertEquals("Teste 10", entries.get(9).getDescription());
            assertEquals(500.0d, entries.get(9).getValue(), 0.0001);
            assertEquals(new Date(1510272000000L), entries.get(9).getDate());
            assertEquals(EntryType.LAZER, entries.get(9).getType());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    @RunAsClient
    public void it_should_gets_entrys_starting_from_the_initial_period() {
        try {
            List<Entry> entries = target
                    .queryParam("initialPeriod", "2017-11-10")
                    .request()
                    .get(new GenericType<List<Entry>>() {
                    });

            assertEquals(21, entries.size());
            assertEquals("Teste 10", entries.get(0).getDescription());
            assertEquals(500.0d, entries.get(0).getValue(), 0.0001);
            assertEquals(new Date(1510272000000L), entries.get(0).getDate());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    @RunAsClient
    public void it_should_delete_an_entry_by_id() {
        try {
            Response response = target
                    .path("21")
                    .request()
                    .delete();

            assertEquals(200, response.getStatus());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    @RunAsClient
    public void it_should_gets_an_entry_by_id() {
        try {
            Entry entry = target
                    .path("1")
                    .request()
                    .get(Entry.class);

            assertEquals("Teste 1", entry.getDescription());
            assertEquals(120.0d, entry.getValue(), 0.0001);
            assertEquals(new Date(1509494400000L), entry.getDate());
        } catch (Exception e) {
            fail();
        }
    }
}

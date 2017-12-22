package com.luan.myfin.financeiro.ejb;

import com.luan.myfin.ArquillianInitializerIT;
import com.luan.myfin.financeiro.base.enums.EntryType;
import com.luan.myfin.financeiro.base.models.Entry;
import java.sql.Date;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EntryResourceIntegrationTest extends ArquillianInitializerIT {

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
    @InSequence(1)
    public void it_should_gets_all_entries() {

        try {
            List<Entry> entries = target
                    .request()
                    .get(new GenericType<List<Entry>>() {
                    });

            assertEquals(46, entries.size());
            assertEquals("Teste 1", entries.get(0).getDescription());
            assertEquals(120.0d, entries.get(0).getValue(), 0.0001);
            assertEquals(new Date(1509494400000L), entries.get(0).getDate());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @RunAsClient
    @InSequence(2)
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
            fail(e.getMessage());
        }
    }

    @Test
    @RunAsClient
    @InSequence(3)
    public void it_should_insert_entry() {
        Entry entry = new Entry();
        entry.setDescription("Big lanção");
        entry.setType(EntryType.ALIMENTACAO);
        entry.setValue(50.0d);
        entry.setDate(new Date(1509494400000L));

        try {
            Entity<Entry> entity = Entity.entity(entry, MediaType.APPLICATION_JSON);
            Response response = target
                    .request()
                    .header("Content-Type", "application/json")
                    .accept(MediaType.APPLICATION_JSON)
                    .post(entity, Response.class);

            String location = response.getHeaderString("Location");
            assertEquals(201, response.getStatus());
            assertTrue(location.contains("entry/47"));
            
            Entry newEntry = response.readEntity(Entry.class);
            assertEquals(EntryType.ALIMENTACAO, newEntry.getType());
            assertEquals("Big lanção", newEntry.getDescription());
            assertEquals(50.0d, newEntry.getValue(), 0.000001);
            //assertEquals(new Date(1509494400000L).toString(), newEntry.getDate().toString());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @RunAsClient
    @InSequence(4)
    public void it_should_not_insert_the_entry_because_the_request_has_null_params() {
        Entry entry = new Entry();
        entry.setDescription("Big lanção");

        try {
            Entity<Entry> entity = Entity.entity(entry, MediaType.APPLICATION_JSON);
            target
                    .request()
                    .header("Content-Type", "application/json")
                    .accept(MediaType.APPLICATION_JSON)
                    .post(entity, List.class);

            fail();
        } catch (BadRequestException e) {
            assertEquals("HTTP 400 Bad Request", e.getMessage());
        }
    }

    @Test
    @RunAsClient
    @InSequence(5)
    public void it_should_filters_by_description() {
        try {
            List<Entry> entries = target
                    .queryParam("description", " 4")
                    .request()
                    .get(new GenericType<List<Entry>>() {
                    });

            //assertEquals(8, entries.size());
            assertEquals("Teste 4", entries.get(0).getDescription());
            assertEquals(200.0d, entries.get(0).getValue(), 0.0001);
            assertEquals(new Date(1509753600000L), entries.get(0).getDate());
            assertEquals(EntryType.MORADIA, entries.get(0).getType());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @RunAsClient
    @InSequence(6)
    public void it_should_filters_by_type() {
        try {
            List<Entry> entries = target
                    .queryParam("type", "SAUDE")
                    .request()
                    .get(new GenericType<List<Entry>>() {
                    });

            //assertEquals(3, entries.size());
            assertEquals("Teste 11", entries.get(0).getDescription());
            assertEquals(500.0d, entries.get(0).getValue(), 0.0001);
            assertEquals(new Date(1510358400000L), entries.get(0).getDate());
            assertEquals(EntryType.SAUDE, entries.get(0).getType());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @RunAsClient
    @InSequence(7)
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
            fail(e.getMessage());
        }
    }

    @Test
    @RunAsClient
    @InSequence(8)
    public void it_should_gets_entrys_starting_from_the_initial_period() {
        try {
            List<Entry> entries = target
                    .queryParam("initialPeriod", "2017-11-10")
                    .request()
                    .get(new GenericType<List<Entry>>() {
                    });

            //assertEquals(21, entries.size());
            assertEquals("Teste 10", entries.get(0).getDescription());
            assertEquals(500.0d, entries.get(0).getValue(), 0.0001);
            assertEquals(new Date(1510272000000L), entries.get(0).getDate());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @RunAsClient
    @InSequence(9)
    public void it_should_delete_an_entry_by_id() {
        try {
            Response response = target
                    .path("21")
                    .request()
                    .delete();

            assertEquals(200, response.getStatus());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    } 
    
    @Test
    @RunAsClient
    @InSequence(10)
    public void it_should_update_an_entry() {
        Entry entry = new Entry();
        entry.setDescription("Atualizado");
        entry.setType(EntryType.ALIMENTACAO);
        entry.setValue(50.0d);
        entry.setDate(new Date(1509494400000L));

        try {
            Entity<Entry> entity = Entity.entity(entry, MediaType.APPLICATION_JSON);
            Response response = target
                    .path("13")
                    .request()
                    .header("Content-Type", "application/json")
                    .accept(MediaType.APPLICATION_JSON)
                    .put(entity, Response.class);

            Entry updatedEntry = (Entry) response.readEntity(Entry.class);

            assertEquals(202, response.getStatus());
            assertEquals(EntryType.ALIMENTACAO, updatedEntry.getType());
            assertEquals("Atualizado", updatedEntry.getDescription());
            //assertEquals(new Date(1509494400000L), updatedEntry.getDate());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}

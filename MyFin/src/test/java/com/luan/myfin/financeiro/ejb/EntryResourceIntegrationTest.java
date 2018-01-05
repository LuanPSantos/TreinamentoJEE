package com.luan.myfin.financeiro.ejb;

import com.luan.myfin.ArquillianInitializerIT;
import com.luan.myfin.financeiro.base.models.Entry;
import com.luan.myfin.financeiro.base.models.EntryType;
import com.luan.myfin.financeiro.base.util.DateUtils;
import java.sql.Date;
import java.util.Arrays;
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
import org.jboss.arquillian.junit.InSequence;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EntryResourceIntegrationTest extends ArquillianInitializerIT {

    private Client client;
    private WebTarget target;

    private List<Entry> createEntries() {

        Entry e1 = new Entry();
        e1.setDescription("Teste 1");
        e1.setEntryDate(Date.valueOf(DateUtils.today().withDayOfMonth(10)));
        e1.setEntryType(new EntryType("ALIMENTACAO"));
        e1.setEntryValue(100d);

        Entry e2 = new Entry();
        e1.setDescription("Teste 2");
        e1.setEntryDate(Date.valueOf(DateUtils.today().withDayOfMonth(11)));
        e1.setEntryType(new EntryType("ALIMENTACAO"));
        e1.setEntryValue(200d);

        Entry e3 = new Entry();
        e1.setDescription("Teste 3");
        e1.setEntryDate(Date.valueOf(DateUtils.today().withDayOfMonth(12)));
        e1.setEntryType(new EntryType("MORADIA"));
        e1.setEntryValue(300d);

        Entry e4 = new Entry();
        e1.setDescription("Teste 4");
        e1.setEntryDate(Date.valueOf(DateUtils.today().withDayOfMonth(12)));
        e1.setEntryType(new EntryType("LAZER"));
        e1.setEntryValue(400d);

        Entry e5 = new Entry();
        e5.setDescription("Teste 5");
        e5.setEntryDate(Date.valueOf(DateUtils.today().withDayOfMonth(15)));
        e5.setEntryType(new EntryType("SAUDE"));
        e5.setEntryValue(500.0d);

        return Arrays.asList(e1, e2, e3, e4, e5);
    }

    @Before
    public void before() throws InterruptedException {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/webapi/entry");
    }

    @After
    public void after() {
        client.close();
    }

    @Test
    public void test_that_the_test_works() {
        assertTrue(true);
    }

    @Test
    @RunAsClient
    @InSequence(1)
    public void it_should_insert_entry() {
        Entry e6 = new Entry();
        e6.setDescription("Teste 6");
        e6.setEntryDate(Date.valueOf(DateUtils.today().withDayOfMonth(16)));
        e6.setEntryType(new EntryType("TRANSAPORTE"));
        e6.setEntryValue(600.0d);

        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/webapi/entry");
        try {
            Entity<Entry> entity = Entity.entity(e6, MediaType.APPLICATION_JSON);
            Response response = target
                    .request()
                    .header("Content-Type", "application/json")
                    .accept(MediaType.APPLICATION_JSON)
                    .post(entity, Response.class);

            String location = response.getHeaderString("Location");
            assertEquals(201, response.getStatus());
            assertTrue(location.contains("entry/1"));
            Entry newEntry = response.readEntity(Entry.class);
            assertEquals(new EntryType("TRANSAPORTE"), newEntry.getEntryType());
            assertEquals("Teste 6", newEntry.getDescription());
            assertEquals(600.0d, newEntry.getEntryValue(), 0.000001);
            //assertEquals(new Date(1509494400000L).toString(), newEntry.getDate().toString());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

//    @Test
//    @RunAsClient
//    @InSequence(2)
//    public void it_should_gets_entrys_until_the_final_period() {
//        try {
//            List<Entry> entries = target
//                    .queryParam("finalPeriod", DateUtils.today().withDayOfMonth(15).format(DateTimeFormatter.ISO_DATE))
//                    .request()
//                    .get(new GenericType<List<Entry>>() {
//                    });
//
//            System.out.println(entries);
//            assertEquals(5, entries.size());
//            assertEquals("Teste 5", entries.get(4).getDescription());
//            assertEquals(500.0d, entries.get(5).getEntryValue(), 0.0001);
//            //assertEquals(DateUtils.today().withDayOfMonth(15), entries.get(4).getEntryDate());
//            assertEquals("SAUDE", entries.get(4).getEntryType());
//        } catch (Exception e) {
//            fail(e.getMessage());
//        }
//    }
//
    @Test
    @RunAsClient
    @InSequence(3)
    public void it_should_gets_all_entries() {
        try {

            Entity<Entry> entity = Entity.entity(createEntries().get(0), MediaType.APPLICATION_JSON);
            Response post = target
                    .request()
                    .header("Content-Type", "application/json")
                    .accept(MediaType.APPLICATION_JSON)
                    .post(entity, Response.class);

            client.close();
            client = ClientBuilder.newClient();
            target = client.target("http://localhost:8080/webapi/entry/");
            Response response = target
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get(Response.class);

            System.out.println("\n\n\n" + response.getStatus());

            List<Entry> entries = response.readEntity(new GenericType<List<Entry>>() { });
            System.out.println("\n\n\n" + entries);
            assertEquals(6, entries.size());
            assertEquals("Teste 1", entries.get(0).getDescription());
            assertEquals(100.0d, entries.get(0).getEntryValue(), 0.0001);
            assertEquals("ALIMENTACAO", entries.get(4).getEntryType());
            //assertEquals(new Date(1509494400000L), entries.get(0).getEntryDate());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
//
//    @Test
//    @RunAsClient
//    @InSequence(4)
//    public void it_should_not_insert_the_entry_because_the_request_has_null_params() {
//        Entry entry = new Entry();
//        entry.setDescription("Big lanção");
//
//        try {
//            Entity<Entry> entity = Entity.entity(entry, MediaType.APPLICATION_JSON);
//            target
//                    .request()
//                    .header("Content-Type", "application/json")
//                    .accept(MediaType.APPLICATION_JSON)
//                    .post(entity, List.class);
//
//            fail();
//        } catch (BadRequestException e) {
//            assertEquals("HTTP 400 Bad Request", e.getMessage());
//        }
//    }
//
//    @Test
//    @RunAsClient
//    @InSequence(5)
//    public void it_should_filters_by_description() {
//        try {
//            List<Entry> entries = target
//                    .queryParam("description", " 4")
//                    .request()
//                    .get(new GenericType<List<Entry>>() {
//                    });
//
//            //assertEquals(8, entries.size());
//            assertEquals("Teste 4", entries.get(0).getDescription());
//            assertEquals(200.0d, entries.get(0).getEntryValue(), 0.0001);
//            assertEquals(new Date(1509753600000L), entries.get(0).getEntryDate());
//            assertEquals("MORADIA", entries.get(0).getEntryType());
//        } catch (Exception e) {
//            fail(e.getMessage());
//        }
//    }
//
//    @Test
//    @RunAsClient
//    @InSequence(6)
//    public void it_should_filters_by_type() {
//        try {
//            List<Entry> entries = target
//                    .queryParam("type", "SAUDE")
//                    .request()
//                    .get(new GenericType<List<Entry>>() {
//                    });
//
//            //assertEquals(3, entries.size());
//            assertEquals("Teste 11", entries.get(0).getDescription());
//            assertEquals(500.0d, entries.get(0).getEntryValue(), 0.0001);
//            assertEquals(new Date(1510358400000L), entries.get(0).getEntryDate());
//            assertEquals("SAUDE", entries.get(0).getEntryType());
//        } catch (Exception e) {
//            fail(e.getMessage());
//        }
//    }
//
//    @Test
//    @RunAsClient
//    @InSequence(7)
//    public void it_should_gets_an_entry_by_id() {
//        try {
//            Entry entry = target
//                    .path("1")
//                    .request()
//                    .get(Entry.class);
//
//            assertEquals("Teste 1", entry.getDescription());
//            assertEquals(120.0d, entry.getEntryValue(), 0.0001);
//            assertEquals(new Date(1509494400000L), entry.getEntryDate());
//        } catch (Exception e) {
//            fail(e.getMessage());
//        }
//    }
//
//    @Test
//    @RunAsClient
//    @InSequence(8)
//    public void it_should_gets_entrys_starting_from_the_initial_period() {
//        try {
//            List<Entry> entries = target
//                    .queryParam("initialPeriod", "2017-11-10")
//                    .request()
//                    .get(new GenericType<List<Entry>>() {
//                    });
//
//            //assertEquals(21, entries.size());
//            assertEquals("Teste 10", entries.get(0).getDescription());
//            assertEquals(500.0d, entries.get(0).getEntryValue(), 0.0001);
//            assertEquals(new Date(1510272000000L), entries.get(0).getEntryDate());
//        } catch (Exception e) {
//            fail(e.getMessage());
//        }
//    }
//
//    @Test
//    @RunAsClient
//    @InSequence(9)
//    public void it_should_delete_an_entry_by_id() {
//        try {
//            Response response = target
//                    .path("21")
//                    .request()
//                    .delete();
//
//            assertEquals(200, response.getStatus());
//        } catch (Exception e) {
//            fail(e.getMessage());
//        }
//    }
//
//    @Test
//    @RunAsClient
//    @InSequence(10)
//    public void it_should_update_an_entry() {
//        Entry entry = new Entry();
//        entry.setDescription("Atualizado");
//        entry.setEntryType(new EntryType("ALIMENTACAO"));
//        entry.setEntryValue(50.0d);
//        entry.setEntryDate(new Date(1509494400000L));
//
//        try {
//            Entity<Entry> entity = Entity.entity(entry, MediaType.APPLICATION_JSON);
//            Response response = target
//                    .path("13")
//                    .request()
//                    .header("Content-Type", "application/json")
//                    .accept(MediaType.APPLICATION_JSON)
//                    .put(entity, Response.class);
//
//            Entry updatedEntry = (Entry) response.readEntity(Entry.class);
//
//            assertEquals(202, response.getStatus());
//            assertEquals("ALIMENTACAO", updatedEntry.getEntryType());
//            assertEquals("Atualizado", updatedEntry.getDescription());
//            //assertEquals(new Date(1509494400000L), updatedEntry.getDate());
//        } catch (Exception e) {
//            fail(e.getMessage());
//        }
//    }
}

package com.luan.myfin.financeiro.ejb;

import com.luan.myfin.ArquillianInitializerIT;
import com.luan.myfin.financeiro.base.models.Entry;
import com.luan.myfin.financeiro.base.models.EntryType;
import com.luan.myfin.financeiro.base.util.DateUtils;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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

        Entry e6 = new Entry();
        e6.setDescription("Teste 6");
        e6.setEntryDate(Date.valueOf(DateUtils.today().withDayOfMonth(16)));
        e6.setEntryType(new EntryType("TRANSPORTE"));
        e6.setEntryValue(600.0d);

        List<Entry> all = new ArrayList<>();
        all.add(e1);
        all.add(e2);
        all.add(e3);
        all.add(e4);
        all.add(e5);
        all.add(e6);
        System.out.println(all);
        return all;
    }

    @Before
    public void before() throws InterruptedException {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/myfin/webapi/entry");
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
        Entry entry = createEntries().get(5);

        try {
            Entity<Entry> entity = Entity.entity(entry, MediaType.APPLICATION_JSON);
            Response response = target
                    .request()
                    .header("Content-Type", "application/json")
                    .accept(MediaType.APPLICATION_JSON)
                    .post(entity, Response.class);

            String location = response.getHeaderString("Location");
            assertEquals(201, response.getStatus());
            assertTrue(location.contains("entry/1"));
            Entry newEntry = response.readEntity(Entry.class);
            assertEquals(new EntryType("TRANSPORTE"), newEntry.getEntryType());
            assertEquals("Teste 6", newEntry.getDescription());
            assertEquals(600.0d, newEntry.getEntryValue(), 0.000001);
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
                    .queryParam("finalPeriod", DateUtils.today().withDayOfMonth(18).format(DateTimeFormatter.ISO_DATE))
                    .request()
                    .get(new GenericType<List<Entry>>() {
                    });

            assertEquals(1, entries.size());
            assertEquals("Teste 6", entries.get(0).getDescription());
            assertEquals(600.0d, entries.get(0).getEntryValue(), 0.0001);
            assertEquals(new EntryType("TRANSPORTE"), entries.get(0).getEntryType());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @RunAsClient
    @InSequence(3)
    public void it_should_gets_all_entries() {
        try {
            Response response = target
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get(Response.class);

            List<Entry> entries = response.readEntity(new GenericType<List<Entry>>() {
            });

            assertEquals(1, entries.size());
            assertEquals("Teste 6", entries.get(0).getDescription());
            assertEquals(600.0d, entries.get(0).getEntryValue(), 0.0001);
            assertEquals(new EntryType("TRANSPORTE"), entries.get(0).getEntryType());
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
                    .queryParam("description", "Teste 6")
                    .request()
                    .get(new GenericType<List<Entry>>() {
                    });

            assertEquals(1, entries.size());
            assertEquals("Teste 6", entries.get(0).getDescription());
            assertEquals(600.0d, entries.get(0).getEntryValue(), 0.0001);
            assertEquals(new EntryType("TRANSPORTE"), entries.get(0).getEntryType());
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
                    .queryParam("type", "TRANSPORTE")
                    .request()
                    .get(new GenericType<List<Entry>>() {
                    });

            assertEquals(1, entries.size());
            assertEquals("Teste 6", entries.get(0).getDescription());
            assertEquals(600.0d, entries.get(0).getEntryValue(), 0.0001);
            assertEquals(new EntryType("TRANSPORTE"), entries.get(0).getEntryType());
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

            assertEquals("Teste 6", entry.getDescription());
            assertEquals(600.0d, entry.getEntryValue(), 0.0001);
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
                    .queryParam("initialPeriod", DateUtils.today().withDayOfMonth(1).format(DateTimeFormatter.ISO_DATE))
                    .request()
                    .get(new GenericType<List<Entry>>() {
                    });

            assertEquals(1, entries.size());
            assertEquals("Teste 6", entries.get(0).getDescription());
            assertEquals(600.0d, entries.get(0).getEntryValue(), 0.0001);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @RunAsClient
    @InSequence(9)
    public void it_should_update_an_entry() {
        Entry entry = new Entry();
        entry.setDescription("Atualizado");
        entry.setEntryType(new EntryType("ALIMENTACAO"));
        entry.setEntryValue(50.0d);
        entry.setEntryDate(Date.valueOf(DateUtils.today().withDayOfMonth(18)));

        try {
            Entity<Entry> entity = Entity.entity(entry, MediaType.APPLICATION_JSON);
            Response response = target
                    .path("1")
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .put(entity, Response.class);

            Entry updatedEntry = (Entry) response.readEntity(Entry.class);

            assertEquals(202, response.getStatus());
            assertEquals(new EntryType("ALIMENTACAO"), updatedEntry.getEntryType());
            assertEquals("Atualizado", updatedEntry.getDescription());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @RunAsClient
    @InSequence(10)
    public void it_should_delete_an_entry_by_id() {
        try {
            Response response = target
                    .path("1")
                    .request()
                    .delete();

            assertEquals(200, response.getStatus());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}

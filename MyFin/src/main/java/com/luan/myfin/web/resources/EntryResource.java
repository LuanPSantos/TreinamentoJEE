package com.luan.myfin.web.resources;

import com.luan.myfin.base.interfaces.EntryService;
import com.luan.myfin.base.enums.EntryType;
import com.luan.myfin.base.models.Entry;
import java.net.URI;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.apache.commons.collections.CollectionUtils;

@Path("entry")
public class EntryResource {

    @EJB
    private EntryService entryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectEntryById(
            @QueryParam("type") EntryType type,
            @QueryParam("initialPeriod") Date initialPeriod,
            @QueryParam("finalPeriod") Date finalPeriod,
            @QueryParam("description") String description
    ) {
        List<Entry> entries = entryService.selectEntries(type, initialPeriod, finalPeriod, description);

        if (CollectionUtils.isNotEmpty(entries)) {
            return Response.ok(entries).build();
        } else {
            return Response.noContent().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertEntry(@Context UriInfo uriInfo, Entry entry) {
        Entry newEntry = entryService.insertEntry(entry);

        if (newEntry.getId() != null) {
            URI uri = uriInfo.getAbsolutePathBuilder().path(newEntry.getId().toString()).build();
            return Response.created(uri).entity(newEntry).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}

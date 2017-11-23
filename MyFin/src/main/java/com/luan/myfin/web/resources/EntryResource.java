package com.luan.myfin.web.resources;

import com.luan.myfin.ejb.EntryService;
import com.luan.myfin.models.Entry;
import java.net.URI;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("entry")
public class EntryResource {

    @EJB
    private EntryService entryService;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectEntryById(@PathParam("id") Long id) {
        Entry entry = entryService.selectEntryById(id);

        if (entry != null) {
            return Response.ok(entry).build();
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

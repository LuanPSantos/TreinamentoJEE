package com.luan.myfin.web.resources;

import com.luan.myfin.ejb.EntryService;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("entry")
public class EntryResource {

    @EJB
    private EntryService entryService;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectEntryById(@PathParam("id") Long id) {
        return Response.ok(entryService == null ? "Hello from WildFly Swarm!" : entryService.selectEntryById(id)).build();
    }
}

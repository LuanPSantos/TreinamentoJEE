package com.luan.myfin.web.resources;

import com.luan.myfin.ejb.EntryService;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/hello")
public class EntryResource {
    
    @EJB
    private EntryService entryService;

    @GET
    @Produces("text/plain")
    public Response doGet() {
        return Response.ok(entryService == null ? "Hello from WildFly Swarm!" : entryService.teste()).build();
    }
}

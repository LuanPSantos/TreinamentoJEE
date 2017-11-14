package com.luan.resources;

import com.luan.helloejb.lib.interfaces.Main;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ejb.EJB;
import javax.ws.rs.QueryParam;

@Path("main")
public class MainResource {
    
    @EJB
    private Main main;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findMessage(@QueryParam("text") String text) {
        return Response.ok(main.findMessage(text)).build();
    }
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllMessages(){
        return Response.ok(main.findAllMessage()).build();
    }
}

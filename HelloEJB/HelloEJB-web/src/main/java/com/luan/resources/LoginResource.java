package com.luan.resources;

import com.luan.helloejb.lib.models.Message;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("secured/login")
public class LoginResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response login() {
        return Response.ok(new Message("Autenticado!")).build();
    }
}

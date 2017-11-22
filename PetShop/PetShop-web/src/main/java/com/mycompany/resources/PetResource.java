package com.mycompany.resources;


import com.mycompany.petshot.beans.PetHandler;
import com.mycompany.petshot.models.Pet;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pet")
public class PetResource {

    @EJB
    private PetHandler handler;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPet(@PathParam("id") String id) {
        
        Pet pet = handler.getPet(Integer.parseInt(id));

        return Response.ok(pet).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPetAllPets() {
        
        List<Pet> pets = handler.getAllPets();

        return Response.ok(pets).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response savaPet(Pet pet) {
        handler.savePet(pet);

        return Response.ok().build();
    }
}

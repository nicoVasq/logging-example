package at.htl.rest;

import at.htl.entity.Guitar;
import at.htl.service.GuitarService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/guitar")

public class GuitarEndpoint {

    @Inject
    GuitarService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(){
        return "Site's running!";
    }

    //PUT
    //...
    //DELETE
    //..

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Guitar guitar){
        try {

            service.save(guitar);

            return Response.ok().entity(guitar).build();

        } catch (Exception ex){

            return Response.status(400).build();
        }
    }


}

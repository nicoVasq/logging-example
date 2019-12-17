package at.htl.rest;

import at.htl.entity.Guitar;
import at.htl.service.GuitarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/guitar")
public class GuitarEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(GuitarEndpoint.class);

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

        logger.debug("Entering add method");

        try {
            service.save(guitar);

            logger.info("Save successful: " + guitar.toString());

            return Response.ok().entity(guitar).build();

        } catch (Exception ex){
            logger.error("Error while saving: " + ex.getMessage());

            return Response.status(400).build();
        }
    }


}

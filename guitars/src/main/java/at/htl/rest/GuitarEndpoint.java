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

    //tag::logger[]
    private static final Logger logger = LoggerFactory.getLogger(GuitarEndpoint.class);
    //end::logger[]
    @Inject
    GuitarService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(){
        return "Site's running!";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON) //tag::usage[]
    public Response add(Guitar guitar){

        logger.debug("Entering add method"); //<1>

        try {
            service.save(guitar);

            logger.info("Save successful: " + guitar.toString()); //<2>

            return Response.ok().entity(guitar).build();

        } catch (Exception ex){
            logger.error("Error while saving: " + ex.getMessage()); //<3>

            return Response.status(400).build();
        }
    } //end::usage[]


}

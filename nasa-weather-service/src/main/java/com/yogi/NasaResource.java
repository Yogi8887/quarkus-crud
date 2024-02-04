package com.yogi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.Random;

@Path("/api")
public class NasaResource {

    public static final Logger LOGGER = Logger.getLogger(NasaResource.class);
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("weather_by_country/{country}")
    public Response weatherByCountry(@PathParam("country") String country){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("calling nasa weather:: by country");
        return Response.
                ok("Weather of"+country+":"+new Random().nextInt(40))
                .build();
    }

}

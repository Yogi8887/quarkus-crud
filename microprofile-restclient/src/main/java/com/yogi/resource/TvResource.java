package com.yogi.resource;

import jakarta.json.JsonArray;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/tvseries")
public class TvResource {

    @RestClient
    private TvSeriesIdProxy proxy;

    @GET
    @Fallback(fallbackMethod = "getTVSeriesByIdFallback")
    @Path("/{id}")
    public Response getTvSeriesById(@PathParam("id") int id){
        return Response.ok(proxy.getTvSeriesById(id)).build();
    }

    public Response getTVSeriesByIdFallback(int id){
        return Response.ok("Service is down now").build();
    }
    @GET
    @Path("/people/{person}")
    JsonArray getTvSeriesByPerson(@PathParam("person") String  person){
        return proxy.getTvSeriesByPerson(person);
    }

}

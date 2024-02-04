package com.yogi.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8081")
@Path("/api")
public interface WeatherProxy {

    @GET
    @Path("/weather_by_country/{country}")
    public Response weatherByCountry(@PathParam("country") String con);
}

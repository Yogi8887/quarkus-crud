package com.yogi.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.time.temporal.ChronoUnit;

@Path("/")
public class WeatherResource {
    public static final Logger LOGGER = Logger.getLogger(WeatherResource.class);
    @RestClient
    private WeatherProxy weatherProxy;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("weather/{country}")
    @Fallback(fallbackMethod = "getWeatherFallback")
    // @Retry(maxRetries = 3)
    //@Timeout(1000)
    @CircuitBreaker(requestVolumeThreshold = 4,
            failureRatio = 0.5,
            delay = 60, delayUnit = ChronoUnit.SECONDS)
    public Response getWeatherByCountry(@PathParam("country") String cou) {
        LOGGER.info("calling nasa weather:: getWeather by country");
        /*
        // this logic for test @Retry and @Timeout.
        Long startTime = System.currentTimeMillis();
        Response response = weatherProxy.weatherByCountry(cou);
        Long endTime = System.currentTimeMillis();
        String res = response.readEntity(String.class);
        res = res + ">>>" + ((endTime - startTime)/1000);
        return Response.ok(res).build();*/

        // test of circuit breaker with this script on gitbash
        //while true; do sleep 1; curl http://localhost:8080/weather/India; echo -e '\n'; done

        return Response.ok(weatherProxy.weatherByCountry(cou)).build();
    }

    public Response getWeatherFallback(String cou) {
        return Response.ok("server is down, please wait").build();
    }
}

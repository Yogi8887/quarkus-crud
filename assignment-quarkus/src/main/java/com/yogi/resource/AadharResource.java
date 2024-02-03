package com.yogi.resource;

import com.yogi.request.AadharRequest;
import com.yogi.request.EmployeeRequest;
import com.yogi.service.AadharService;
import com.yogi.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("/aadhar")
public class AadharResource {
    @Inject
    private AadharService aadharService;
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(AadharRequest aadharRequest){
        aadharService.saveAadhar(aadharRequest);
        return Response.created(URI.create("aadhar/"+aadharRequest.getAadharNumber())).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAadhar(){
        return Response.ok(aadharService.getAllAadhar()).build();
    }
}

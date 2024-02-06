package com.yogi.resource;

import com.yogi.request.AadharRequest;
import com.yogi.request.AddressRequest;
import com.yogi.service.AadharService;
import com.yogi.service.AddressService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.Objects;

@Path("/address")
public class AddressResource {
    @Inject
    private AddressService addressService;
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(AddressRequest addressRequest){
        if (Objects.isNull(addressRequest)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        addressService.saveAddress(addressRequest);
        return Response.created(URI.create("address" + addressRequest.getCityName())).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAddress(){
        return Response.ok(addressService.getAllAddress()).build();
    }
}

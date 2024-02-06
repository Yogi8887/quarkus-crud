package com.yogi.resource;

import com.yogi.entity.Employee;
import com.yogi.request.EmployeeRequest;
import com.yogi.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.Objects;

@Path("/employee")
public class EmployeeResource {
    @Inject
    private EmployeeService employeeService;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(EmployeeRequest employeeRequest) {
        if (Objects.isNull(employeeRequest)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        employeeService.saveEmployee(employeeRequest);
        return Response.created(URI.create("employee" + employeeRequest.getName())).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getEmployeeById(@PathParam("id") Long id) {
        return Response.ok(employeeService.getEmployeeById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployee() {
        return Response.ok(employeeService.getAllEmployee()).build();
    }
}

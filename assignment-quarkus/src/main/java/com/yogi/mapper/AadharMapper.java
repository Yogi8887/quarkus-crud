package com.yogi.mapper;

import com.yogi.entity.Aadhar;
import com.yogi.entity.Employee;
import com.yogi.request.AadharRequest;
import com.yogi.request.EmployeeRequest;
import com.yogi.response.AadharResponse;
import com.yogi.response.EmployeeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="cdi")
public interface AadharMapper {
    Aadhar fromRequestToEntity(AadharRequest aadharRequest);

    List<AadharResponse> fromEntityToResponse(List<Aadhar> aadhars);
}

package com.yogi.mapper;

import com.yogi.entity.Employee;
import com.yogi.request.EmployeeRequest;
import com.yogi.response.EmployeeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="cdi")
public interface EmployeeMapper {
    Employee fromRequestToEntity(EmployeeRequest employeeRequest);

    List<EmployeeResponse> fromEntityToResponse(List<Employee> employee);
}

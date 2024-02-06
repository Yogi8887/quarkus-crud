package com.yogi.service;

import com.yogi.request.EmployeeRequest;
import com.yogi.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getAllEmployee();

    EmployeeResponse getEmployeeById(Long id);
}

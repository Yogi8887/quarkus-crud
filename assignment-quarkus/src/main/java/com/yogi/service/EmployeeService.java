package com.yogi.service;

import com.yogi.entity.Employee;
import com.yogi.request.EmployeeRequest;
import com.yogi.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    public void saveEmployee(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getAllEmployee();
}

package com.yogi.service.impl;

import com.yogi.mapper.EmployeeMapper;
import com.yogi.repository.EmployeeRepository;
import com.yogi.request.EmployeeRequest;
import com.yogi.response.EmployeeResponse;
import com.yogi.service.EmployeeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {
    @Inject
    private EmployeeRepository employeeRepository;

    @Inject
    private EmployeeMapper employeeMapper;

    @Override
    public void saveEmployee(EmployeeRequest employeeRequest) {
        employeeRepository.persist(employeeMapper.fromRequestToEntity(employeeRequest));
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        return employeeMapper.fromEntityToResponse(employeeRepository.listAll());
    }
}

package com.yogi.service.impl;

import com.yogi.entity.Employee;
import com.yogi.repository.EmployeeRepository;
import com.yogi.request.EmployeeRequest;
import com.yogi.response.AadharResponse;
import com.yogi.response.AddressResponse;
import com.yogi.response.EmployeeResponse;
import com.yogi.service.EmployeeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {
    @Inject
    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(EmployeeRequest employeeRequest) {
        employeeRepository.persist(fromRequestToEntity(employeeRequest));
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        return employeeRepository.listAll().stream()
                .map(employee -> fromEntityToResponse(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        if ((id < 0)) {
            throw new RuntimeException("Please Enter valid ID");
        }
        return fromEntityToResponse(employeeRepository.findById(id));
    }

    private EmployeeResponse fromEntityToResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        if (employee != null) {
            employeeResponse.setId(employee.getId());
            employeeResponse.setName(employee.getName());
            AadharResponse aadharResponse = new AadharResponse();
            if (employee.getAadhar() != null) {
                aadharResponse.setId(employee.getAadhar().getId());
                aadharResponse.setAadharNumber(employee.getAadhar().getAadharNumber());
                aadharResponse.setEmployeeId(employee.getId());
            }
            employeeResponse.setAadharResponse(aadharResponse);
            List<AddressResponse> addressResponses = new ArrayList<>();
            if (employee.getAddresses() != null) {
                employee.getAddresses().forEach(address -> {
                    AddressResponse addressResponse = new AddressResponse();
                    addressResponse.setId(address.getId());
                    addressResponse.setCityName(address.getCityName());
                    addressResponse.setEmployeeId(address.getEmployeeId().getId());
                    addressResponses.add(addressResponse);

                });
            }
            employeeResponse.setAddressResponse(addressResponses);
        }
        return employeeResponse;
    }

    private Employee fromRequestToEntity(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        if (employeeRequest != null) {
            employee.setName(employeeRequest.getName());
        }
        return employee;
    }

}

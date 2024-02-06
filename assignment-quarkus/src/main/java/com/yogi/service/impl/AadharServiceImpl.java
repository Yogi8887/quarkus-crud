package com.yogi.service.impl;

import com.yogi.entity.Aadhar;
import com.yogi.repository.AadharRepository;
import com.yogi.repository.EmployeeRepository;
import com.yogi.request.AadharRequest;
import com.yogi.response.AadharResponse;
import com.yogi.service.AadharService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AadharServiceImpl implements AadharService {

    @Inject
    private EmployeeRepository employeeRepository;
    @Inject
    private AadharRepository aadharRepository;
    @Override
    public void saveAadhar(AadharRequest aadharRequest) {
        if(employeeRepository.findById(aadharRequest.getEmployeeId()) != null) {
            aadharRepository.persist(fromRequestToEntity(aadharRequest));
        }
    }

    @Override
    public List<AadharResponse> getAllAadhar() {
        return aadharRepository.listAll().stream()
                .map(aadhar -> fromEntityToResponse(aadhar))
                .collect(Collectors.toList());
    }

    private Aadhar fromRequestToEntity(AadharRequest aadharRequest){
        Aadhar aadhar = new Aadhar();
        if(aadharRequest != null){
            aadhar.setAadharNumber(aadharRequest.getAadharNumber());
            aadhar.setEmployeeId(employeeRepository.findById(aadharRequest.getEmployeeId()));
        }
        return aadhar;
    }

    private AadharResponse fromEntityToResponse(Aadhar aadhar){
        AadharResponse aadharResponse = new AadharResponse();
        if(aadhar != null){
            aadharResponse.setId(aadhar.getId());
            aadharResponse.setAadharNumber(aadhar.getAadharNumber());
            aadharResponse.setEmployeeId(aadhar.getEmployeeId().getId());
        }
        return aadharResponse;
    }
}

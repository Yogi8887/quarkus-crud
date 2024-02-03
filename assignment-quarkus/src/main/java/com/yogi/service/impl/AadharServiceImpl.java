package com.yogi.service.impl;

import com.yogi.mapper.AadharMapper;
import com.yogi.repository.AadharRepository;
import com.yogi.request.AadharRequest;
import com.yogi.response.AadharResponse;
import com.yogi.service.AadharService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class AadharServiceImpl implements AadharService {

    @Inject
    private AadharMapper aadharMapper;
    private AadharRepository aadharRepository;
    @Override
    public void saveAadhar(AadharRequest aadharRequest) {
        aadharRepository.persist(aadharMapper.fromRequestToEntity(aadharRequest));
    }

    @Override
    public List<AadharResponse> getAllAadhar() {
        return aadharMapper.fromEntityToResponse(aadharRepository.listAll());
    }
}

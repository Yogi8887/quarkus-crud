package com.yogi.service;

import com.yogi.request.AadharRequest;
import com.yogi.response.AadharResponse;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
public interface AadharService {

    void saveAadhar(AadharRequest aadharRequest);

    List<AadharResponse> getAllAadhar();
}

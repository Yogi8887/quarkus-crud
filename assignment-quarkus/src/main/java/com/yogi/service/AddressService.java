package com.yogi.service;

import com.yogi.request.AddressRequest;
import com.yogi.response.AddressResponse;

import java.util.List;

public interface AddressService {

    List<AddressResponse> getAllAddress();

    void saveAddress(AddressRequest addressRequest);
}

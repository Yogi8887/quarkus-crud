package com.yogi.service.impl;

import com.yogi.entity.Address;
import com.yogi.repository.AddressRepository;
import com.yogi.repository.EmployeeRepository;
import com.yogi.request.AddressRequest;
import com.yogi.response.AddressResponse;
import com.yogi.service.AddressService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AddressServiceImpl implements AddressService {
    @Inject
    private EmployeeRepository employeeRepository;
    @Inject
    private AddressRepository addressRepository;

    @Override
    public List<AddressResponse> getAllAddress() {
        return addressRepository.listAll().stream()
                .map(address -> fromEntityToResponse(address))
                .collect(Collectors.toList());
    }

    @Override
    public void saveAddress(AddressRequest addressRequest) {
        if (employeeRepository.findById(addressRequest.getEmployeeId()) != null) {
            addressRepository.persist(fromRequestToEntity(addressRequest));
        }
    }

    private Address fromRequestToEntity(AddressRequest addressRequest) {
        Address address = new Address();
        if (addressRequest != null) {
            address.setCityName(addressRequest.getCityName());
            address.setEmployeeId(employeeRepository.findById(addressRequest.getEmployeeId()));
        }
        return address;
    }

    private AddressResponse fromEntityToResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        if (address != null) {
            addressResponse.setId(address.getId());
            addressResponse.setCityName(address.getCityName());
            addressResponse.setEmployeeId(address.getEmployeeId().getId());
        }
        return addressResponse;
    }

}

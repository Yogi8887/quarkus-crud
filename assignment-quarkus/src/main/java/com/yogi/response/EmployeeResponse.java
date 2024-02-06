package com.yogi.response;

import java.util.ArrayList;
import java.util.List;

public class EmployeeResponse {
    private Long id;
    private String name;
    private AadharResponse aadharResponse;
    private List<AddressResponse> addressResponse = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AadharResponse getAadharResponse() {
        return aadharResponse;
    }

    public void setAadharResponse(AadharResponse aadharResponse) {
        this.aadharResponse = aadharResponse;
    }

    public List<AddressResponse> getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(List<AddressResponse> addressResponse) {
        this.addressResponse = addressResponse;
    }
}

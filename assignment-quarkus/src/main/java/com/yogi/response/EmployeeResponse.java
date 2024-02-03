package com.yogi.response;

public class EmployeeResponse {
    private Long id;
    private String name;
    private AadharResponse aadharResponse;

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
}

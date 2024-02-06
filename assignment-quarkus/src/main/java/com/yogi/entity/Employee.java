package com.yogi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(generator = "employee_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "employee_id_seq",
            sequenceName = "employee_seq",
            allocationSize = 5
    )
    private Long id;
    private String name;
    @JsonManagedReference
    @OneToOne(mappedBy = "employeeId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Aadhar aadhar;

    @OneToMany(mappedBy = "employeeId", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Address> addresses = new ArrayList<>();

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

    public Aadhar getAadhar() {
        return aadhar;
    }

    public void setAadhar(Aadhar aadhar) {
        this.aadhar = aadhar;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}

package com.yogi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Aadhar {
    @Id
    @GeneratedValue(generator = "aadhar_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "aadhar_id_seq",
            sequenceName = "aadhar_seq",
            allocationSize = 5
    )
    private Long id;
    @Column(unique = true)
    @Size(min = 12, max = 12)
    private String aadharNumber;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name="employee_id")
    private Employee employeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }
}

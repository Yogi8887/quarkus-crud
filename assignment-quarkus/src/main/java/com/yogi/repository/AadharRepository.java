package com.yogi.repository;

import com.yogi.entity.Aadhar;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AadharRepository implements PanacheRepository<Aadhar> {
}

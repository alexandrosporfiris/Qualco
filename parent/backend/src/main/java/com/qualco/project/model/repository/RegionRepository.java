package com.qualco.project.model.repository;

import com.qualco.project.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RegionRepository extends JpaRepository<Region, BigInteger> {
}

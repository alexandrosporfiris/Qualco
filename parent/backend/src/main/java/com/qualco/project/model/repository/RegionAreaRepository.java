package com.qualco.project.model.repository;

import com.qualco.project.model.RegionArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionAreaRepository extends JpaRepository<RegionArea, String> {
}

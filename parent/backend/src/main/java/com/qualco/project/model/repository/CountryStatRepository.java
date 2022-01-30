package com.qualco.project.model.repository;

import com.qualco.project.model.CountryStat;
import com.qualco.project.model.CountryStatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryStatRepository extends JpaRepository<CountryStat, CountryStatId> {
}

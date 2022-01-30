package com.qualco.project.model.repository;

import com.qualco.project.model.view.ContinentsCountriesView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContinentsCountriesViewRepository extends JpaRepository<ContinentsCountriesView, String>, JpaSpecificationExecutor<ContinentsCountriesView> {

    @Query("SELECT DISTINCT new java.lang.String(cc.regionName) FROM ContinentsCountriesView cc")
    List<String> fetchDistinctRegions();
}

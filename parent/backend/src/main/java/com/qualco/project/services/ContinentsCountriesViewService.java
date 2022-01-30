package com.qualco.project.services;

import com.qualco.project.model.view.ContinentsCountriesView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


public interface ContinentsCountriesViewService{

    Page<ContinentsCountriesView> searchContinentsCountriesView(Specification<ContinentsCountriesView> continentsCountriesViewSpecification, Pageable pageable);

    List<String> getDistinctRegions();
}

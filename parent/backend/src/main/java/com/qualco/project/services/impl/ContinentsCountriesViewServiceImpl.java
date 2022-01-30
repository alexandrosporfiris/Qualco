package com.qualco.project.services.impl;

import com.qualco.project.model.repository.ContinentsCountriesViewRepository;
import com.qualco.project.model.view.ContinentsCountriesView;
import com.qualco.project.services.ContinentsCountriesViewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class ContinentsCountriesViewServiceImpl implements ContinentsCountriesViewService {

    private final ContinentsCountriesViewRepository continentsCountriesViewRepository;

    @Override
    public Page<ContinentsCountriesView> searchContinentsCountriesView(Specification<ContinentsCountriesView> continentsCountriesViewSpecification, Pageable pageable) {
        return continentsCountriesViewRepository.findAll(continentsCountriesViewSpecification,pageable);
    }

    @Override
    public List<String> getDistinctRegions() {
        return continentsCountriesViewRepository.fetchDistinctRegions();
    }
}

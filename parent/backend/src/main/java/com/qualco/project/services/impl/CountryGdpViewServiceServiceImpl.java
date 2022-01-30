package com.qualco.project.services.impl;

import com.qualco.project.model.repository.CountryGdpViewRepository;
import com.qualco.project.model.view.CountryGdpView;
import com.qualco.project.services.CountryGdpViewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Transactional
@Service
public class CountryGdpViewServiceServiceImpl implements CountryGdpViewService {

    private final CountryGdpViewRepository countryGdpViewRepository;

    @Override
    public Page<CountryGdpView> getCountryGdpViewSortablePageable(Pageable pageable) {
        return countryGdpViewRepository.findAll(pageable);
    }
}

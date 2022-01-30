package com.qualco.project.services;

import com.qualco.project.model.view.CountryGdpView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryGdpViewService {

    Page<CountryGdpView> getCountryGdpViewSortablePageable(Pageable pageable);
}

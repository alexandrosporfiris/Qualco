package com.qualco.project.services;

import com.qualco.project.dto.CountryViewDTO;
import com.qualco.project.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;

public interface CountryService extends AppBaseService<Country, BigInteger> {

    Page<CountryViewDTO> getCountriesView(Pageable pageable);
}

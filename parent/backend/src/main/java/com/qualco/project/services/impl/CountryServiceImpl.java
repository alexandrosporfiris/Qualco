package com.qualco.project.services.impl;

import com.qualco.project.dto.CountryViewDTO;
import com.qualco.project.mappers.CountryMapper;
import com.qualco.project.model.Country;
import com.qualco.project.model.repository.CountryRepository;
import com.qualco.project.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public Country getById(BigInteger id) {
        return countryRepository.getOne(id);
    }

    @Override
    public List<Country> getAll() {
        return null;
    }

    @Override
    public boolean delete(BigInteger id) {
        return false;
    }

    @Override
    public Country createWithEntity(Country country) {
        return null;
    }

    @Override
    public Page<CountryViewDTO> getCountriesView(Pageable pageable) {
        return countryRepository.fetchCountriesView(pageable);
    }
}

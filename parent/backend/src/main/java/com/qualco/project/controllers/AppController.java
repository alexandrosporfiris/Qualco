package com.qualco.project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qualco.project.helpers.AppUtils;
import com.qualco.project.helpers.ContinentsCountriesFilters;
import com.qualco.project.helpers.SearchSort;
import com.qualco.project.model.view.ContinentsCountriesView;
import com.qualco.project.dto.CountryViewDTO;
import com.qualco.project.dto.LanguageDTO;
import com.qualco.project.mappers.CountryMapper;
import com.qualco.project.model.view.CountryGdpView;
import com.qualco.project.services.ContinentsCountriesViewService;
import com.qualco.project.services.CountryGdpViewService;
import com.qualco.project.services.CountryService;
import com.qualco.project.specification.ContinentsCountriesViewSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@AllArgsConstructor
@RestController
@RequestMapping(value = "api/search")
public class AppController {

    private static final Logger logger = Logger.getLogger(AppController.class.getName());
    private final CountryService countryService;
    private final ContinentsCountriesViewService continentsCountriesViewService;
    private final CountryGdpViewService countryGdpViewService;
    private final CountryMapper countryMapper;


    @GetMapping(value = "/getAllCountriesView", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CountryViewDTO>> getAllCategories(@RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNumber,
                                                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                                 @RequestParam(name = "sort", required = false) String encodedSort) throws JsonProcessingException {
        logger.log(Level.INFO, "Fetching all Countries (View)");
        if (Objects.nonNull(encodedSort)) {
            SearchSort sort = (SearchSort) AppUtils.objectDecoder(encodedSort, SearchSort.class);
            return ResponseEntity.ok(
                    countryService.getCountriesView(PageRequest.of(pageNumber, pageSize, sort.getOrder() == 1 ? Sort.by(sort.getField()).ascending() : Sort.by(sort.getField()).descending())));
        }
        return ResponseEntity.ok(countryService.getCountriesView(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping(value = "/getCountriesGpdView", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CountryGdpView>> getCountriesGpdView(@RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNumber,
                                                                    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name = "sort", required = false) String encodedSort) throws JsonProcessingException {
        logger.log(Level.INFO, "Fetching all Countries GDP (View)");
        if (Objects.nonNull(encodedSort)) {
            SearchSort sort = (SearchSort) AppUtils.objectDecoder(encodedSort, SearchSort.class);
            return ResponseEntity.ok(
                    countryGdpViewService.getCountryGdpViewSortablePageable(PageRequest.of(pageNumber, pageSize, sort.getOrder() == 1 ? Sort.by(sort.getField()).ascending() : Sort.by(sort.getField()).descending())));
        }

        return ResponseEntity.ok(countryGdpViewService.getCountryGdpViewSortablePageable(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping(value = "/getAllCountryLanguages/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LanguageDTO>> getAllCountryLanguages(@PathVariable BigInteger countryId) {
        logger.log(Level.INFO, "Fetching all Languages for Country with id: " + countryId);
        return ResponseEntity.ok(countryMapper.toDto(countryService.getById(countryId)).getLanguages());
    }

    @GetMapping(value = "/getDistinctRegions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getDistinctRegions() {
        logger.log(Level.INFO, "Fetching all Regions in ContinentsCountriesView");
        return ResponseEntity.ok(continentsCountriesViewService.getDistinctRegions());
    }

    @GetMapping(value = "/getContinentsCountriesView", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ContinentsCountriesView>> getContinentsCountriesView(@RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNumber,
                                                                                    @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                                                    @RequestParam(name = "sort", required = false) String encodedSort,
                                                                                    @RequestParam(name = "filters", required = false) String encodedfilters) throws JsonProcessingException {
        logger.log(Level.INFO, "Fetching all Continents Countries (View)");
        ContinentsCountriesViewSpecification continentsCountriesViewSpecification;
        if(Objects.nonNull(encodedfilters)){
            ContinentsCountriesFilters continentsCountriesFilters = (ContinentsCountriesFilters) AppUtils.objectDecoder(encodedfilters, ContinentsCountriesFilters.class);
            continentsCountriesViewSpecification = new ContinentsCountriesViewSpecification(
                    continentsCountriesFilters.getRegionName(),continentsCountriesFilters.getStartYear(),continentsCountriesFilters.getEndYear());
        }else {
            continentsCountriesViewSpecification = new ContinentsCountriesViewSpecification(null, null, null);
        }

        if (Objects.nonNull(encodedSort)) {
            SearchSort sort = (SearchSort) AppUtils.objectDecoder(encodedSort, SearchSort.class);
            return ResponseEntity.ok(continentsCountriesViewService.searchContinentsCountriesView(Specification.where(continentsCountriesViewSpecification),
                    PageRequest.of(pageNumber, pageSize, sort.getOrder() == 1 ? Sort.by(sort.getField()).ascending() : Sort.by(sort.getField()).descending())));
        }
        return ResponseEntity.ok(continentsCountriesViewService.searchContinentsCountriesView(Specification.where(continentsCountriesViewSpecification), PageRequest.of(pageNumber, pageSize)));
    }
}

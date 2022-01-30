package com.qualco.project.model.repository;

import com.qualco.project.dto.CountryViewDTO;
import com.qualco.project.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.math.BigInteger;

@Repository
public interface CountryRepository extends JpaRepository<Country, BigInteger> {

    @Query("SELECT new com.qualco.project.dto.CountryViewDTO(c.id, c.name, c.area, c.countryCode2) FROM Country c")
    Page<CountryViewDTO> fetchCountriesView(Pageable pageable);

    /** This was my initial approach but i wanted to make the search dynamic so i made a view */
    //@Query("SELECT new com.qualco.project.dto.ContinentsCountriesViewDTO(c.name, r.name, con.name, cs.year, cs.population, cs.gdp) FROM Country c INNER JOIN Region r ON c.region = r INNER JOIN Continent con ON r.continent = con INNER JOIN CountryStat cs ON cs.country = c")
    //List<ContinentsCountriesView> fetchContinentsCountriesView(Specification<ContinentsCountriesView> continentsCountriesViewSpecification, Pageable pageable);

}


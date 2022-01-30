package com.qualco.project.model.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Immutable
@Table(name = "continents_countries")
@Subselect("select uuid() as id, cc.* from continents_countries cc")
public class ContinentsCountriesView {

    @Id
    private String id;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "continent_name")
    private String continentName;

    @Column(name = "year")
    private BigInteger year;

    @Column(name = "population")
    private BigInteger population;

    @Column(name = "gdp")
    private BigDecimal gdp;

}

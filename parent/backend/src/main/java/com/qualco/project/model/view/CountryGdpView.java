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
@Table(name = "gdp")
@Subselect("select uuid() as id, cg.* from gdp cg")
public class CountryGdpView {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "country_code3")
    private String countryCode3;

    @Column(name = "year")
    private BigInteger year;

    @Column(name = "population")
    private BigInteger population;

    @Column(name = "gdp")
    private BigDecimal gdp;

    @Column(name = "ratio")
    private BigDecimal ratio;

}

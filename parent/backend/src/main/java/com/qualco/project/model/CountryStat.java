package com.qualco.project.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@IdClass(CountryStatId.class)
@Table(name = "country_stats")
public class CountryStat {

    @Id
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Id
    @Column(name = "year")
    private BigInteger year;

    @Column(name = "population")
    private BigInteger population;

    @Column(name = "gdp")
    private BigDecimal gdp;
}

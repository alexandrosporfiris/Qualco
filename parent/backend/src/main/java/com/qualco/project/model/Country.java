package com.qualco.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "countries")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private BigInteger id;

    @Nullable
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "area")
    private BigDecimal area;

    @Nullable
    @Temporal(TemporalType.DATE)
    @Column(name = "national_day")
    private Date utilDate;

    @NonNull
    @Column(name = "country_code2", length = 2)
    private String countryCode2;

    @NonNull
    @Column(name = "country_code3", length = 3)
    private String countryCode3;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToMany
    @JoinTable(name = "country_languages", joinColumns = {
            @JoinColumn(name = "country_id")}, inverseJoinColumns = {@JoinColumn(name = "language_id")})
    private List<Language> languages;

}

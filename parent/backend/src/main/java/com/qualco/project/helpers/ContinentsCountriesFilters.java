package com.qualco.project.helpers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContinentsCountriesFilters {

    private String regionName;

    private BigInteger startYear;

    private BigInteger endYear;

}

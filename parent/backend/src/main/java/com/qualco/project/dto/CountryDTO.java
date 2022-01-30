package com.qualco.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDTO {

    private String id;

    private String name;

    private BigDecimal area;

    private Date utilDate;

    private String countryCode2;

    private String countryCode3;

    private RegionDTO region;

    private List<LanguageDTO> languages;
}

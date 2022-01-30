package com.qualco.project.mappers;

import com.qualco.project.dto.CountryDTO;
import com.qualco.project.dto.CountryViewDTO;
import com.qualco.project.model.Country;
import org.mapstruct.Builder;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {RegionMapper.class, LanguageMapper.class})
public interface CountryMapper extends AppMapper<Country, CountryDTO> {

}

package com.qualco.project.mappers;

import com.qualco.project.dto.RegionDTO;
import com.qualco.project.model.Region;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {ContinentMapper.class})
public interface RegionMapper extends AppMapper<Region, RegionDTO> {
}

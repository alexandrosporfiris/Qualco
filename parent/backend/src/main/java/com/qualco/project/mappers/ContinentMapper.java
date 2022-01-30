package com.qualco.project.mappers;

import com.qualco.project.dto.ContinentDTO;
import com.qualco.project.model.Continent;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface ContinentMapper extends AppMapper<Continent, ContinentDTO>{
}

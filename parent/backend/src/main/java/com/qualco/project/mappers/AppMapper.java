package com.qualco.project.mappers;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;

import java.util.Collection;
import java.util.List;

public interface AppMapper<ENTITY, DTO> {

    @InheritConfiguration
    DTO toDto(ENTITY entity);

    @InheritConfiguration
    List<DTO> toDto(Collection<ENTITY> entity);

    @InheritInverseConfiguration
    ENTITY toEntity(DTO dto);

    @InheritInverseConfiguration
    List<ENTITY> toEntity(Collection<DTO> dto);
}

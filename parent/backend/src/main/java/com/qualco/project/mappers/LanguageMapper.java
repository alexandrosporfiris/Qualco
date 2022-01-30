package com.qualco.project.mappers;

import com.qualco.project.dto.LanguageDTO;
import com.qualco.project.model.Language;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface LanguageMapper extends AppMapper<Language, LanguageDTO>{
}

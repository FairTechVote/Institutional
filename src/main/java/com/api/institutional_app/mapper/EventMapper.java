package com.api.institutional_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.institutional_app.dto.RequestEvent;
import com.api.institutional_app.dto.ResponseEvent;
import com.api.institutional_app.dto.SummaryInstitute;
import com.api.institutional_app.dto.SummaryProject;
import com.api.institutional_app.entity.Event;
import com.api.institutional_app.entity.Institute;
import com.api.institutional_app.entity.Project;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "projects", ignore = true)
    @Mapping(target = "institute", ignore = true)
    Event toEntity(RequestEvent dto);

    @Mapping(target = "initialDate", expression = "java(entity.getInitialDate().toString())")
    @Mapping(target = "endDate", expression = "java(entity.getEndDate().toString())")
    ResponseEvent toDto(Event entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "cnpj", source = "cnpj")
    SummaryInstitute toSummaryInstitute(Institute institute);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    SummaryProject toSummaryProject(Project project);

}

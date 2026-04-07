package com.api.institutional_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.institutional_app.dto.RequestProject;
import com.api.institutional_app.dto.ResponseProject;
import com.api.institutional_app.dto.SummaryEventDto;
import com.api.institutional_app.dto.SummaryVisitor;
import com.api.institutional_app.entity.Event;
import com.api.institutional_app.entity.Project;
import com.api.institutional_app.entity.Visitor;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "event", ignore = true)
    @Mapping(target = "votes", ignore = true)
    Project toEntity(RequestProject dto);

    ResponseProject toDto(Project entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "Title", source = "title")
    @Mapping(target = "Description", source = "description")
    SummaryEventDto toSummaryEventDto(Event event);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "cpf", source = "cpf")
    SummaryVisitor toSummaryVisitor(Visitor visitor);

}

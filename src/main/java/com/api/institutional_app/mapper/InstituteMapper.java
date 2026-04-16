package com.api.institutional_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.institutional_app.dto.RequestInstitute;
import com.api.institutional_app.dto.ResponseInstitute;
import com.api.institutional_app.dto.SummaryCoordinatorDto;
import com.api.institutional_app.dto.SummaryEventDto;
import com.api.institutional_app.entity.CoordinatorInstitute;
import com.api.institutional_app.entity.Event;
import com.api.institutional_app.entity.Institute;

@Mapper(componentModel = "spring")
public interface InstituteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "coordinatorInstitutes", ignore = true)
    @Mapping(target = "events", ignore = true)
    Institute toEntity(RequestInstitute dto);

    @Mapping(target = "coordinators", source = "coordinatorInstitutes")
    ResponseInstitute toDto(Institute entity);

    @Mapping(target = "id", source = "coordinator.id")
    @Mapping(target = "name", source = "coordinator.name")
    SummaryCoordinatorDto tSummaryCoordinatorDto(CoordinatorInstitute coordinatorInstitute);

    @Mapping(target = "Title", source = "event.title")
    @Mapping(target = "Description", source = "event.description")
    SummaryEventDto toSummaryEventDto(Event event);

}

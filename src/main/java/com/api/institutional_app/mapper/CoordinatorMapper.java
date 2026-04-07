package com.api.institutional_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.institutional_app.dto.RequestCoordinator;
import com.api.institutional_app.dto.ResponseCoordinator;
import com.api.institutional_app.dto.SummaryInstitute;
import com.api.institutional_app.entity.Coordinator;
import com.api.institutional_app.entity.CoordinatorInstitute;

@Mapper(componentModel = "spring")
public interface CoordinatorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "coordinatorInstitutes", ignore = true)
    Coordinator toEntity(RequestCoordinator dto);

    @Mapping(target = "institutes", source = "coordinatorInstitutes")
    ResponseCoordinator toDto(Coordinator entity);

    @Mapping(target = "id", source = "institute.id")
    @Mapping(target = "name", source = "institute.name")
    @Mapping(target = "cnpj", source = "institute.cnpj")
    SummaryInstitute toSummaryInstitute(CoordinatorInstitute coordinatorInstitute);

}

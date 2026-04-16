package com.api.institutional_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.institutional_app.dto.RequestVisitor;
import com.api.institutional_app.dto.ResponseVisitor;
import com.api.institutional_app.dto.SummaryProject;
import com.api.institutional_app.entity.Visitor;
import com.api.institutional_app.entity.Vote;

@Mapper(componentModel = "spring")
public interface VisitorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "votes", ignore = true)
    Visitor toEntity(RequestVisitor dto);

    @Mapping(target = "votes", source = "votes")
    ResponseVisitor toDto(Visitor entity);

    @Mapping(target = "id", source = "project.id")
    @Mapping(target = "title", source = "project.title")
    @Mapping(target = "description", source = "project.description")
    SummaryProject toSummaryProject(Vote vote);

}

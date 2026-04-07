package com.api.institutional_app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.institutional_app.dto.SummarySysLogs;
import com.api.institutional_app.entity.SysLogs;

@Mapper(componentModel = "spring")
public interface SysLogsMapper {

    @Mapping(target = "changedAt", expression = "java(sysLogs.getChangedAt().toString())")
    SummarySysLogs toSummary(SysLogs sysLogs);

    List<SummarySysLogs> toSummaryList(List<SysLogs> sysLogsList);

}

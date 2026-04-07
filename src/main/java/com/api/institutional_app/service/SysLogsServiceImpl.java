package com.api.institutional_app.service;

import com.api.institutional_app.mapper.SysLogsMapper;
import com.api.institutional_app.repository.SysLogsRepository;

import com.api.institutional_app.dto.RequestSysLogsByDate;
import com.api.institutional_app.dto.ResponseSysLogsByDate;
import com.api.institutional_app.dto.SummarySysLogs;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SysLogsServiceImpl implements SysLogsService {

    private final SysLogsRepository repository;
    private final SysLogsMapper mapper;

    @Override
    public ResponseSysLogsByDate getSysLogsByDate(RequestSysLogsByDate request) {

        LocalDateTime start = LocalDateTime.parse(request.startDate());
        LocalDateTime end = LocalDateTime.parse(request.endDate());

        List<SummarySysLogs> logs = mapper.toSummaryList(
                repository.findByChangedAtBetween(start, end));

        return new ResponseSysLogsByDate(logs);

    }
}

package com.api.institutional_app.service;

import com.api.institutional_app.mapper.SysLogsMapper;
import com.api.institutional_app.repository.SysLogsRepo;

import com.api.institutional_app.dto.RequestSysLogsByDate;
import com.api.institutional_app.dto.ResponseSysLogsByDate;
import com.api.institutional_app.dto.SummarySysLogs;
import com.api.institutional_app.exception.NoRecordsFoundException;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SysLogsServiceImpl implements SysLogsService {

    private final SysLogsRepo repository;
    private final SysLogsMapper mapper;

    @Override
    public ResponseSysLogsByDate getSysLogsByDate(RequestSysLogsByDate request) {

        LocalDateTime start = LocalDateTime.parse(request.startDate());
        LocalDateTime end = LocalDateTime.parse(request.endDate());

        List<SummarySysLogs> logs = mapper.toSummaryList(
                repository.findByChangedAtBetween(start, end));

        if (logs == null || logs.isEmpty()) {
            throw new NoRecordsFoundException(
                    "Nenhum log encontrado entre " + request.startDate() + " e " + request.endDate());
        }

        return new ResponseSysLogsByDate(logs);

    }
}

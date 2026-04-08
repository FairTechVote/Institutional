package com.api.institutional_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.institutional_app.dto.RequestSysLogsByDate;
import com.api.institutional_app.dto.ResponseSysLogsByDate;
import com.api.institutional_app.service.SysLogsServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/audit")
@RequiredArgsConstructor
public class AuditController {

    private final SysLogsServiceImpl sysLogsServiceImpl;

    @PostMapping("/by-date")
    public ResponseEntity<ResponseSysLogsByDate> postMethodName(
            @RequestBody RequestSysLogsByDate request) {
        return ResponseEntity.ok(sysLogsServiceImpl.getSysLogsByDate(request));
    }

}

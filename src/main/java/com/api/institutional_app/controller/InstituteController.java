package com.api.institutional_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.institutional_app.dto.CoordinatorInstituteListResponse;
import com.api.institutional_app.service.InstituteServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/institutes")
@RequiredArgsConstructor
public class InstituteController {

    private final InstituteServiceImpl instituteService;

    @GetMapping("/coordinator/{coordinatorId}/institute")
    public ResponseEntity<CoordinatorInstituteListResponse> getCoordinatorInstitutes(@PathVariable Long coordinatorId) {
        CoordinatorInstituteListResponse response = instituteService.getCoordinatorInstitute(coordinatorId);
        return ResponseEntity.ok(response);
    }

}

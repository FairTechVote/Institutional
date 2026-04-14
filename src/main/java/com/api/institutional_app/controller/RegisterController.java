package com.api.institutional_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.institutional_app.dto.CoordinatorAuthResponse;
import com.api.institutional_app.dto.RequestCoordinator;
import com.api.institutional_app.service.RegisterService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("/coordinator")
    public ResponseEntity<CoordinatorAuthResponse> registerCoordinator(@RequestBody RequestCoordinator request) {
        CoordinatorAuthResponse response = registerService.registerCoordinator(request);
        return ResponseEntity.ok(response);
    }

}

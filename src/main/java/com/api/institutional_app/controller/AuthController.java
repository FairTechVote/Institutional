package com.api.institutional_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.institutional_app.dto.CoordinatorAuthRequest;
import com.api.institutional_app.dto.CoordinatorAuthResponse;
import com.api.institutional_app.service.AuthServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Auth service is running");
    }

    @PostMapping("/coordinator")
    public ResponseEntity<CoordinatorAuthResponse> coordinatorLogin(@RequestBody CoordinatorAuthRequest request) {
        System.out.println("INSTANCE: " + System.identityHashCode(this));
        CoordinatorAuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

}

package com.api.institutional_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.institutional_app.dto.CoordinatorAuthResponse;
import com.api.institutional_app.dto.RequestCoordinator;
import com.api.institutional_app.service.RegisterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/register")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Register service is running");
    }

    @PostMapping("/coordinator")
    @Operation(summary = "Register a new coordinator", description = "Endpoint to register a new coordinator in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coordinator registered successfully"),
            @ApiResponse(responseCode = "404", description = "email already in use"),
            @ApiResponse(responseCode = "404", description = "cpf already in use"),
    })
    public ResponseEntity<CoordinatorAuthResponse> registerCoordinator(@RequestBody RequestCoordinator request) {
        CoordinatorAuthResponse response = registerService.registerCoordinator(request);
        return ResponseEntity.ok(response);
    }

}

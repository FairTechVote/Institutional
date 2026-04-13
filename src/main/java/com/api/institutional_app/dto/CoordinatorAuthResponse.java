package com.api.institutional_app.dto;

public record CoordinatorAuthResponse(
        String token,
        Long coordinatorId,
        String email,
        String name) {

}

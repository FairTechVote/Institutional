package com.api.institutional_app.dto;

import java.util.List;

public record RequestCoordinator(
        String name,
        String cpf,
        String email,
        String password,
        List<Long> instituteIds) {

}

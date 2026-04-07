package com.api.institutional_app.dto;

import java.util.List;

public record ResponseVisitor(
        Long id,
        String name,
        String cpf,
        String email,
        List<SummaryProject> votes) {

}

package com.api.institutional_app.dto;

public record RequestInstitute(
        String name,
        String cnpj,
        Double locallat,
        Double locallong) {
}

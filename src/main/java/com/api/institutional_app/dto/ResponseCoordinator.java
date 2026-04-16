package com.api.institutional_app.dto;

import java.util.List;

import com.api.institutional_app.util.Status;

public record ResponseCoordinator(
        long id,
        String name,
        String cpf,
        String email,
        Status status,
        List<SummaryInstitute> institutes) {

}

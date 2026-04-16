package com.api.institutional_app.dto;

import java.util.List;

import com.api.institutional_app.util.Status;

public record ResponseEvent(
        Long id,
        String title,
        String description,
        double locallat,
        double locallong,
        String initialDate,
        String endDate,
        Status status,
        SummaryInstitute institute,
        List<SummaryProject> projects) {

}

package com.api.institutional_app.dto;

import com.api.institutional_app.util.Status;

public record RequestEvent(
        String title,
        String description,
        double locallat,
        double locallong,
        String initialDate,
        String endDate,
        Long instituteId,
        Status status) {

}

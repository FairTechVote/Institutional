package com.api.institutional_app.dto;

public record RequestEvent(
                String title,
                String description,
                double locallat,
                double locallong,
                String initialDate,
                String endDate,
                Long instituteId) {

}

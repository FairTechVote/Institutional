package com.api.institutional_app.dto;

import java.util.List;

import com.api.institutional_app.util.Status;

public record ResponseProject(
        Long id,
        String title,
        String description,
        Status status,
        SummaryEventDto event,
        List<SummaryVisitor> votes) {

}

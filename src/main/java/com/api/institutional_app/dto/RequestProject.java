package com.api.institutional_app.dto;

import com.api.institutional_app.util.Status;

public record RequestProject(
        String title,
        String description,
        Status status,
        Long event) {

}

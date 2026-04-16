package com.api.institutional_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoRecordsFoundException extends RuntimeException {

    public NoRecordsFoundException(String message) {
        super(message);
    }

}

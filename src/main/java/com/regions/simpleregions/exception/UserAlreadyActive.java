package com.regions.simpleregions.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyActive extends RuntimeException{

    private final HttpStatus status;

    public UserAlreadyActive(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}

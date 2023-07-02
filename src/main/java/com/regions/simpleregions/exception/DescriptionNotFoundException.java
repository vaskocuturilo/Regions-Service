package com.regions.simpleregions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DescriptionNotFoundException extends Exception {
    public DescriptionNotFoundException(String message) {
        super(message);
    }
}

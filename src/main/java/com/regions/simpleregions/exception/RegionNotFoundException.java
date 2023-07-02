package com.regions.simpleregions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegionNotFoundException extends Exception {
    public RegionNotFoundException(String message) {
        super(message);
    }
}

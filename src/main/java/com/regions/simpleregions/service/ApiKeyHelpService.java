package com.regions.simpleregions.service;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.util.function.Supplier;

public class ApiKeyHelpService {
    private static final SecureRandom NUMBERS = new SecureRandom();

    private ApiKeyHelpService() {
    }

    public static Supplier<String> createApiKey() {
        return () -> {
            final byte[] bytes = new byte[128 / 28];
            NUMBERS.nextBytes(bytes);
            return DatatypeConverter.printHexBinary(bytes).toLowerCase();
        };
    }
}

package com.regions.simpleregions.service;

import java.security.SecureRandom;
import java.util.function.Supplier;

public class ApiKeyHelpService {

    private static final Integer LENGTH = 6;

    private static final SecureRandom random = new SecureRandom();

    private ApiKeyHelpService() {
    }

    public static Supplier<Integer> createApiKey() {
        return () -> {
            StringBuilder apiKey = new StringBuilder();
            for (int i = 0; i < LENGTH; i++) {
                int randomNumber = random.nextInt(10);
                apiKey.append(randomNumber);
            }
            return Integer.parseInt(apiKey.toString().trim());
        };
    }
}

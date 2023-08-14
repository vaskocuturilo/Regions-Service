package com.regions.simpleregions.service;

import java.security.SecureRandom;
import java.util.function.Supplier;

public class OneTimePasswordHelpService {

    private static final Integer LENGTH = 6;

    private static final SecureRandom random = new SecureRandom();

    private OneTimePasswordHelpService() {
    }

    public static Supplier<Integer> createRandomOneTimePassword() {
        return () -> {
            StringBuilder oneTimePassword = new StringBuilder();
            for (int i = 0; i < LENGTH; i++) {
                int randomNumber = random.nextInt(10);
                oneTimePassword.append(randomNumber);
            }
            return Integer.parseInt(oneTimePassword.toString().trim());
        };
    }
}

package com.regions.simpleregions.service;

import java.security.SecureRandom;
import java.util.function.Supplier;

public class OneTimePasswordHelpService {

    private static final Integer LENGTH = 6;

    private SecureRandom random = new SecureRandom();

    public Supplier<Integer> createRandomOneTimePassword() {
        return () -> {
            StringBuilder oneTimePassword = new StringBuilder();
            for (int i = 0; i < LENGTH; i++) {
                int randomNumber = this.random.nextInt(10);
                oneTimePassword.append(randomNumber);
            }
            return Integer.parseInt(oneTimePassword.toString().trim());
        };
    }
}

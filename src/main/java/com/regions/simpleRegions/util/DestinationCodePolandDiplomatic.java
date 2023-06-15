package com.regions.simpleRegions.util;

import java.util.Arrays;

public enum DestinationCodePolandDiplomatic {
    PRIVATE_VEHICLES(001, 199),
    PRIVATE_VEHICLE_MILITARY(200, 299),
    PRIVATE_VEHICLE_NON_DIPLOMATIC(300, 499),
    OFFICIAL_VEHICLES_AMBASSADOR(500, 501),
    EMBASSY_VEHICLES(502, 699),
    PRIVATE_VEHICLE_DIPLOMATIC_STAFF_CONSULATE_GENERAL(700, 799),
    PRIVATE_VEHICLE_NON_DIPLOMATIC_STAFF_CONSULATE_GENERAL(800, 899),
    CONSUL_GENERAL_OFFICIAL_VEHICLE(900, 901),
    CONSULATE_GENERAL_SERVICE_VEHICLES(902, 999);
    private final Integer minValue;
    private final Integer maxValue;

    DestinationCodePolandDiplomatic(Integer minNumber, Integer maxNumber) {
        this.minValue = minNumber;
        this.maxValue = maxNumber;
    }

    public static DestinationCodePolandDiplomatic from(int score) {
        return Arrays.stream(DestinationCodePolandDiplomatic.values())
                .filter(destinationCodePolandDiplomatic -> score >= destinationCodePolandDiplomatic.minValue && score <= destinationCodePolandDiplomatic.maxValue)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("You number is incorrect"));
    }
}

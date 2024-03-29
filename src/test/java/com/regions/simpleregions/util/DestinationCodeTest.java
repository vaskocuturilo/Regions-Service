package com.regions.simpleregions.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.MissingFormatArgumentException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DestinationCodeTest {

    private DestinationCode destinationCode;

    @ParameterizedTest
    @MethodSource("getDifferentVehiclesType")
    void getDifferentDestinationCodesForVehiclesTest(String destinationCode, String expectedResult) {
        String actualResult = this.destinationCode.getDestinationCode(destinationCode);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1234567890", "12345"})
    void getLastThreeSymbolsExceptionsTest(String destinationCode) {
        assertThrows(MissingFormatArgumentException.class, () -> {
            this.destinationCode.getDestinationCode(destinationCode);
        });
    }

    static Stream<Arguments> getDifferentVehiclesType() {
        return Stream.of(
                Arguments.of("076140", "PRIVATE_VEHICLES"),
                Arguments.of("076201", "PRIVATE_VEHICLE_MILITARY"),
                Arguments.of("076304", "PRIVATE_VEHICLE_NON_DIPLOMATIC"),
                Arguments.of("076500", "OFFICIAL_VEHICLES_AMBASSADOR"),
                Arguments.of("076503", "EMBASSY_VEHICLES"),
                Arguments.of("076706", "PRIVATE_VEHICLE_DIPLOMATIC_STAFF_CONSULATE_GENERAL"),
                Arguments.of("076802", "PRIVATE_VEHICLE_NON_DIPLOMATIC_STAFF_CONSULATE_GENERAL"),
                Arguments.of("076900", "CONSUL_GENERAL_OFFICIAL_VEHICLE"),
                Arguments.of("076903", "CONSULATE_GENERAL_SERVICE_VEHICLES")
        );
    }
}
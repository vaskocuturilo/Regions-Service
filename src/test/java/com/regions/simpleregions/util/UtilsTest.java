package com.regions.simpleregions.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.MissingFormatArgumentException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UtilsTest {
    @Test
    void getFirstTwoSymbols() {
        String text = "MJ56 VXD";
        String actual = Utils.getFirstTwoSymbols(text);
        assertThat(actual).isEqualTo("MJ");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123", "123456"})
    void getFirstSymbolsExceptionsTest(String testValue) {
        assertThrows(MissingFormatArgumentException.class, () -> Utils.getFirstTwoSymbols(testValue));
    }

    @Test
    void getLastTwoSymbols() {
        String text = "MJ56 VXD";
        String actual = Utils.getLastTwoSymbols(text);
        assertThat(actual).isEqualTo("56");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123", "123456"})
    void getLastSymbolsExceptionsTest(String testValue) {
        assertThrows(MissingFormatArgumentException.class, () -> Utils.getLastTwoSymbols(testValue));
    }

    @Test
    void getFirstThreeSymbols() {
        String text = "076140";
        String actual = Utils.getFirstThreeSymbols(text);
        assertThat(actual).isEqualTo("076");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "07614", "0761401"})
    void getFirstThreeSymbolsExceptionsTest(String testValue) {
        assertThrows(MissingFormatArgumentException.class, () -> Utils.getFirstThreeSymbols(testValue));
    }

    @Test
    void getLastThreeSymbols() {
        String text = "076140";
        String actual = Utils.getLastThreeSymbols(text);
        assertThat(actual).isEqualTo("140");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "07614", "0761401"})
    void getLastThreeSymbolsExceptionsTest(String testValue) {
        assertThrows(MissingFormatArgumentException.class, () -> Utils.getLastThreeSymbols(testValue));
    }
}
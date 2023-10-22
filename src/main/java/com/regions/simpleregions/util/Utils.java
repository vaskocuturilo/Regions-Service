package com.regions.simpleregions.util;

import lombok.experimental.UtilityClass;

import java.util.MissingFormatArgumentException;

@UtilityClass
public class Utils {

    private static final String DATA_SHOULD_BE_EQUALS = "The data %s should be equals %s symbols";

    private static final String IS_EMPTY_DATA = "The data %s should be equals %s symbols";

    public static String getFirstTwoSymbols(String inputData) {
        if (inputData.isEmpty()) {
            throw new MissingFormatArgumentException(String.format(IS_EMPTY_DATA, inputData));
        }

        if (inputData.length() > 8) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 8));
        }

        if (inputData.length() < 8) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 8));
        }
        return inputData.substring(0, 2);
    }

    public static String getLastTwoSymbols(String inputData) {
        if (inputData.isEmpty()) {
            throw new MissingFormatArgumentException(String.format(IS_EMPTY_DATA, inputData));
        }
        if (inputData.length() > 8) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 8));
        }
        if (inputData.length() < 8) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 8));
        }

        return inputData.substring(0, inputData.indexOf(' ')).substring(2, 4);
    }

    public static String getFirstThreeSymbols(String inputData) {
        if (inputData.isEmpty()) {
            throw new MissingFormatArgumentException(String.format(IS_EMPTY_DATA, inputData));
        }
        if (inputData.length() > 6) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 6));
        }
        if (inputData.length() < 6) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 6));
        }
        return inputData.substring(0, 3);
    }

    public static String getLastThreeSymbols(String inputData) {
        if (inputData.isEmpty()) {
            throw new MissingFormatArgumentException(String.format(IS_EMPTY_DATA, inputData));
        }
        if (inputData.length() > 6) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 6));
        }
        if (inputData.length() < 6) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 6));
        }
        return inputData.substring(Math.max(inputData.length() - 3, 0));
    }

    public static String getSecondSymbol(final String inputData) {
        if (inputData.isEmpty()) {
            throw new MissingFormatArgumentException(String.format(IS_EMPTY_DATA, inputData));
        }
        if (inputData.length() > 3) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 3));
        }
        if (inputData.length() < 3) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 3));
        }
        return Character.toString(inputData.charAt(1));
    }
}

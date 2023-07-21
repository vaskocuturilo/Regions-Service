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

        if (inputData.length() > 4) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 4));
        }

        if (inputData.length() < 4) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 4));
        }
        return inputData.length() < 2 ? inputData : inputData.substring(0, 2);
    }

    public static String getLastTwoSymbols(String inputData) {
        if (inputData.isEmpty()) {
            throw new MissingFormatArgumentException(String.format(IS_EMPTY_DATA, inputData));
        }
        if (inputData.length() > 4) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 4));
        }
        if (inputData.length() < 4) {
            throw new MissingFormatArgumentException(String.format(DATA_SHOULD_BE_EQUALS, inputData, 4));
        }
        return inputData.substring(Math.max(inputData.length() - 2, 0));
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
        return inputData.length() < 3 ? inputData : inputData.substring(0, 3);
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
}

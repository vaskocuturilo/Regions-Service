package com.regions.simpleregions.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

    public String getFirstTwoSymbols(String inputData) {
        if (inputData.isEmpty()) {
            throw new IllegalStateException(String.format("The data %s is empty", inputData));
        }

        if (inputData.length() > 4) {
            throw new IllegalStateException(String.format("The data %s should be equals four symbols", inputData));
        }

        if (inputData.length() < 4) {
            throw new IllegalStateException(String.format("The data %s should be equals four symbols", inputData));
        }
        return inputData.length() < 2 ? inputData : inputData.substring(0, 2);
    }

    public String getLastTwoSymbols(String inputData) {
        if (inputData.isEmpty()) {
            throw new IllegalStateException(String.format("The data %s is empty", inputData));
        }
        if (inputData.length() > 4) {
            throw new IllegalStateException(String.format("The data %s should be equals four symbols", inputData));
        }
        if (inputData.length() < 4) {
            throw new IllegalStateException(String.format("The data %s should be equals four symbols", inputData));
        }
        return inputData.substring(Math.max(inputData.length() - 2, 0));
    }

    public String getFirstThreeSymbols(String inputData) {
        if (inputData.isEmpty()) {
            throw new IllegalStateException(String.format("The data %s is empty", inputData));
        }
        if (inputData.length() > 6) {
            throw new IllegalStateException(String.format("The data %s should be equals six symbols", inputData));
        }
        if (inputData.length() < 6) {
            throw new IllegalStateException(String.format("The data %s should be equals six symbols", inputData));
        }
        return inputData.length() < 3 ? inputData : inputData.substring(0, 3);
    }

    public String getLastThreeSymbols(String inputData) {
        if (inputData.isEmpty()) {
            throw new IllegalStateException(String.format("The data %s is empty", inputData));
        }
        if (inputData.length() > 6) {
            throw new IllegalStateException(String.format("The data %s should be equals six symbols", inputData));
        }
        if (inputData.length() < 6) {
            throw new IllegalStateException(String.format("The data %s should be equals six symbols", inputData));
        }
        return inputData.substring(Math.max(inputData.length() - 3, 0));
    }
}

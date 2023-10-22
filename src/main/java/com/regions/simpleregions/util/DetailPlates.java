package com.regions.simpleregions.util;

public class DetailPlates {
    private DetailPlates() {
        throw new IllegalStateException("Utility class");
    }

    public static ParseRegion getDetails(final String region) {
        int letter = 0;
        int number = 0;
        int space = 0;

        for (char c : region.toCharArray()) {
            if (Character.isLetter(c)) {
                letter++;
            } else if (Character.isDigit(c)) {
                number++;
            } else if (Character.isSpaceChar(c)) {
                space++;
            } else {
                throw new IllegalStateException("This item is incorrect");
            }
        }
        return new ParseRegion(letter, number, space);
    }
}

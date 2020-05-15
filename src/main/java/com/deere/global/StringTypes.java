package com.deere.global;

public enum StringTypes {
    ALL,
    ALPHA,
    NUMERIC,
    ALPHANUMERIC,
    ALPHANUMERICSPACE,
    SYMBOLS;

    public static String getValidChars(StringTypes wantedType) {
        String numbers = "0123456789";
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String alphaspace = "abcdefghijkl mnopqrstuvwxyz";
        String symbols = "!@#$%^&*()-=_+`~;,./<>?";

        switch (wantedType) {
            case ALL:
                return numbers + alphaspace + symbols;
            case ALPHA:
                return alpha;
            case NUMERIC:
                return numbers;
            case ALPHANUMERIC:
                return numbers + alpha;
            case ALPHANUMERICSPACE:
                return numbers + alphaspace;
            case SYMBOLS:
                return symbols;
        }
        return "";

    }

    private static StringTypes convertToENUM(String tempType) throws IllegalArgumentException {
        System.out.println("input value: " + tempType);
        for (StringTypes b : values()) {
            System.out.println("enum value: " + b.toString());
            if (b.toString().equalsIgnoreCase(tempType)) {
                return b;
            }
            throw stringNotFound(tempType);
        }
        return null;
    }


    private static IllegalArgumentException stringNotFound(String outcome) {
        return new IllegalArgumentException(("Invalid string type [" + outcome + "]"));
    }
}

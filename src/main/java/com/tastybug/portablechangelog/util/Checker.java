package com.tastybug.portablechangelog.util;

public class Checker {

    public static void ensureNotEmpty(String toCheck, String errorMessage) {
        if (toCheck == null || toCheck.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}

package com.habronat.common.config;

public class MissingConfigurationFileException extends RuntimeException {
    public static final String EXCEPTION_MESSAGE = "Configuration file not found: %s";

    public MissingConfigurationFileException(String filename) {
        super(String.format(EXCEPTION_MESSAGE, filename));
    }
}

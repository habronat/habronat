package com.habronat.common.config;

public class ConfigurationFileParseException extends RuntimeException {
    public static final String EXCEPTION_MESSAGE = "Failed to parse configuration file: %s";

    public ConfigurationFileParseException(String filename) {
        super(String.format(EXCEPTION_MESSAGE, filename));
    }
}

package com.habronat.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class PropertiesConfigLoader implements ConfigLoader<Properties> {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesConfigLoader.class);

    @Override
    public Properties load(String filename) {
        Properties properties = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);

        if (is == null) {
            logger.error(MissingConfigurationFileException.EXCEPTION_MESSAGE, filename);
            throw new MissingConfigurationFileException(filename);
        }

        return parseConfig(properties, is, filename);
    }

    private Properties parseConfig(Properties properties, InputStream is, String filename) {
        try {
            properties.load(is);
        } catch (IOException e) {
            logger.error(String.format(ConfigurationFileParseException.EXCEPTION_MESSAGE, filename));
            throw new ConfigurationFileParseException(filename);
        }

        return properties;
    }
}

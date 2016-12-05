package com.habronat.common.config;

import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PropertiesConfigLoaderTest {

    private PropertiesConfigLoader propertiesConfigLoader;

    @Before
    public void setUp() {
        propertiesConfigLoader = new PropertiesConfigLoader();
    }

    @Test
    public void load() {
        Properties properties = propertiesConfigLoader.load("properties-config.properties");

        assertThat(properties.size(), equalTo(2));
        assertThat(properties.getProperty("property1"), equalTo("value1"));
        assertThat(properties.getProperty("property2"), equalTo("value2"));
    }

    @Test(expected = MissingConfigurationFileException.class)
    public void load_fileNotFound() {
        propertiesConfigLoader.load("file-does-not-exist");
    }

}
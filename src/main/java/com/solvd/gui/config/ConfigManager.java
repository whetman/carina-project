package com.solvd.gui.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigManager.class);
    private Properties prop = new Properties();

    public ConfigManager() {
        loadProperties();
    }

    private void loadProperties() {
        LOGGER.info("loadProperties()");
        try (var input = new FileInputStream(Paths.get("src/main/resources/_config.properties").toFile())) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        String property = prop.getProperty(key);
        LOGGER.info("Retrieved property: " + key + ", " + property);
        return property;
    }

}
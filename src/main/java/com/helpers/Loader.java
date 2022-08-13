package com.helpers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Loader {

    private static final Logger log = LoggerFactory.getLogger("Prop loader");

    private final static File PROPERTY_FILE = new File("src/test/resources/env/app.properties");

    public static String loadProperty(String propName) {
        Properties prop = new Properties();
        try {
            log.info(String.format("Get prop %s from file %s", propName, PROPERTY_FILE.getName()));
            prop.load(new FileInputStream(PROPERTY_FILE));
        }
        catch (IOException e){
            log.error("File reading error");
        }
        return prop.getProperty(propName);
    }
}
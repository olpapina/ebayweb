package com.solvd.ebayweb.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    public static String getData(String propertyKey) {
        Properties properties = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream("src/main/resources/config.properties"));
            properties.load(in);
            in.close();
            return properties.getProperty(propertyKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

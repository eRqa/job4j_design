package ru.job4j.jdbc;

import java.io.InputStream;
import java.util.Properties;

public class Settings {

    private final Properties properties = new Properties();

    public void load(InputStream inputStream) {
        try {
            properties.load(inputStream);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

}

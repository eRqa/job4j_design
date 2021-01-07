package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(line -> !line.matches("\\s*#.*"))
                    .forEach(line -> {
                        String[] currentPair = line.split("=");
                        if (currentPair.length > 1) {
                            values.put(currentPair[0], currentPair[1]);
                        }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new Config("app.properties"));
        Config cfg = new Config("app.properties");
        cfg.load();
    }
}
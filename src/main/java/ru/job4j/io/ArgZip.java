package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgZip {

    private final String[] args;
    private final Map<String, String> parameters = new HashMap<>();

    public ArgZip(String[] args) {
        this.args = args;
        extractParameters();
    }

    private void extractParameters() {
        for (String parameter
                : args) {
            String[] partsOfParameter = parameter.split("=");
            if (partsOfParameter.length < 2) {
                throw new IllegalArgumentException("Incorrect parameters");
            }
            parameters.put(partsOfParameter[0], partsOfParameter[1]);
        }
        if (!valid()) {
            throw new IllegalArgumentException("Incorrect parameters");
        }
    }

    public boolean valid() {
        return parameters.containsKey("-d") && parameters.containsKey("-e") && parameters.containsKey("-o");
    }

    public String directory() {
        return parameters.get("-d");
    }

    public String exclude() {
        return parameters.get("-e");
    }

    public String output() {
        return parameters.get("-o");
    }
}
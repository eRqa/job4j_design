package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Article {
    public static boolean generateBy(String origin, String line) {
        origin = origin.replaceAll("\\p{Punct}", "");
        line = line.replaceAll("\\p{Punct}", "");
        String[] strings = origin.split(" ");
        String[] lines = line.split(" ");
        List<String> words = new ArrayList<>(Arrays.asList(strings));
        return words.containsAll(Arrays.asList(lines));
    }
}
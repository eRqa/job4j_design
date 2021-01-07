package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            List<String> lines = new ArrayList<String>();
            in.lines().forEach(lines::add);
            int a = 5;
            for (String line :
                    lines) {
                String[] allLineParts = line.split(" ");
                String code = allLineParts[allLineParts.length - 2];
                if (code.equals("404")) {
                    result.add(line);
                }
            }
        } catch (Exception e) {

        }
        return result;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.stream().forEach(System.out::println);
    }
}
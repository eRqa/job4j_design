package ru.job4j.io;

import java.io.File;
import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = inputStream.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                boolean isEven = Integer.parseInt(line) % 2 == 0;
                System.out.println("Число " + line + " четное? " + isEven);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
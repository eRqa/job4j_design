package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        StringBuilder result = getUnavailableDiapasons(source);
        if (result.length() > 0) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
                out.write(result.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public StringBuilder getUnavailableDiapasons(String source) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            boolean serverIsAvailable = true;
            while (read.ready()) {
                String[] lines = read.readLine().split(" ");
                if (lines.length > 1) {
                    String status = lines[0];
                    if (serverIsAvailable && (status.equals("400") || status.equals("500"))) {
                        serverIsAvailable = false;
                        result.append(lines[1]).append(";");
                    }
                    if (!serverIsAvailable && (status.equals("300") || status.equals("200"))) {
                        result.append(lines[1]).append("\n");
                        serverIsAvailable = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package ru.job4j.io;

import java.io.FileOutputStream;

public class WriteMultiplicationTable {

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("MultiplicationTable.txt")) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    String rsl = (i + 1) * (j + 1) + "\t";
                    out.write(rsl.getBytes());
                }
                out.write("\n".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

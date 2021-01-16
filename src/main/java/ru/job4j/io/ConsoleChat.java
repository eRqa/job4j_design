package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final List<String> chatLog = new ArrayList<>();
    private final String botAnswers;
    private final List<String> allAnswers = new ArrayList<>();
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        initAnswers();
    }

    private void initAnswers() {
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            while (in.ready()) {
                allAnswers.add(in.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeLog() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            for (String line
                    : chatLog) {
                out.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        boolean stopChat = false;
        boolean continueResponding = true;
        Random random = new Random();
        while (!stopChat) {
            String userInput = in.nextLine();
            chatLog.add(userInput);
            if (userInput.equals(OUT)) {
                stopChat = true;
                continueResponding = false;
                break;
            }
            if (userInput.equals(STOP)) {
                continueResponding = false;
                continue;
            }
            if (userInput.equals(CONTINUE)) {
                continueResponding = true;
                continue;
            }

            if (continueResponding) {
                String botAnswer = allAnswers.get(random.nextInt(allAnswers.size()));
                System.out.println(botAnswer);
                chatLog.add(botAnswer);
            }
        }
        writeLog();
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("chatLog.txt", "botAnswers.txt");
        cc.run();
    }
}
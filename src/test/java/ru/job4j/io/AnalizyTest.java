package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void getUnavailableDiapasons() {
        Analizy analizy = new Analizy();
        StringBuilder act = analizy.getUnavailableDiapasons("unavailable.csv");
        String expected = "10:57:01;10:59:01\n"
                + "11:01:02;11:02:02\n";
        assertThat(act.toString(), is(expected));
    }

    @Test
    public void unavailable() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01\n"
                    + "500 10:57:01\n"
                    + "400 10:58:01\n"
                    + "200 10:59:01\n"
                    + "500 11:01:02\n"
                    + "200 11:02:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            assertThat(in.readLine(), is("10:57:01;10:59:01"));
            assertThat(in.readLine(), is("11:01:02;11:02:02"));
        }
    }
}
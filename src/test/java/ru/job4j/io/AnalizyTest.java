package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void getUnavailableDiapasons() {
        Analizy analizy = new Analizy();
        StringBuilder act = analizy.getUnavailableDiapasons("unavailable.csv");
        String expected = "10:57:01;10:59:01\n" +
                "11:01:02;11:02:02\n";
        assertThat(act.toString(), is(expected));
    }

}
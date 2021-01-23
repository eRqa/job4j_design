package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class FreezeStrTest {

    @Test
    public void whenEq() {
        assertThat(FreezeStr.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.eq("heloo", "hello"), is(false));
    }

    @Test
    public void whenHelloAndHelllo() {
        assertThat(FreezeStr.eq("Helllo", "llleHo"), is(true));
    }

    @Test
    public void whenHelloAndHeliloThenFalse() {
        assertThat(FreezeStr.eq("Hello", "llieHo"), is(false));
    }

    @Test
    public void whenHelloAndHeloThenFalse() {
        assertThat(FreezeStr.eq("Hello", "Helo"), is(false));
    }
}
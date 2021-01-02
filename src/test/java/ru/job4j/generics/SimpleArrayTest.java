package ru.job4j.generics;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayTest {

    SimpleArray<Integer> simpleArray;

    @Before
    public void init() {
        simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoElements() {
        Iterator<Integer> iterator = simpleArray.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test
    public void whenAddElementIsGood() {
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(2));
        assertThat(simpleArray.get(2), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenNoElementWithIndex() {
        simpleArray.get(4);
    }

    @Test()
    public void whenSetElementIsGood() {
        simpleArray.set(0, 10);
        simpleArray.set(2, 7);
        assertThat(simpleArray.get(0), is(10));
        assertThat(simpleArray.get(2), is(7));
    }

    @Test()
    public void whenRemoveElementIsGood() {
        simpleArray.remove(1);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(3));
        assertThat(simpleArray.get(2), is(4));
    }

    @Test()
    public void whenRemoveElementIsGood2() {
        simpleArray.remove(3);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(2));
        assertThat(simpleArray.get(2), is(3));
    }

}
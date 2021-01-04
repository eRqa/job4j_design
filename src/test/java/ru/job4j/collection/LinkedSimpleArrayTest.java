package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LinkedSimpleArrayTest {

    LinkedSimpleArray<Integer> linkedSimpleArray;

    @Before
    public void init() {
        linkedSimpleArray = new LinkedSimpleArray<>();
        linkedSimpleArray.add(1);
        linkedSimpleArray.add(2);
        linkedSimpleArray.add(3);
        linkedSimpleArray.add(4);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoElements() {
        Iterator<Integer> iterator = linkedSimpleArray.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test
    public void whenAddElementIsGood() {
        assertThat(linkedSimpleArray.get(0), is(1));
        assertThat(linkedSimpleArray.get(1), is(2));
        assertThat(linkedSimpleArray.get(2), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenNoElementWithIndex() {
        linkedSimpleArray.get(4);
    }

}
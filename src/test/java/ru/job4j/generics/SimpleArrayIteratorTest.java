package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayIteratorTest {

    @Test
    public void whenEmptyCollectionThenHasNextFalse() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenNotEmptyCollectionThenHasNextFalse() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
    }
}
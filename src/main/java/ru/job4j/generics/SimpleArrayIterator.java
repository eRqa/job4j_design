package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator<T> implements Iterator<T> {

    private Object[] data;
    private int index = 0;
    private int length = 0;

    public SimpleArrayIterator(Object[] data, int length) {
        this.data = data;
        this.length = length;
    }

    @Override
    public boolean hasNext() {
        return length > index;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) data[index++];
    }
}

package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable {

    private int length = 0;
    private Object[] data;

    public SimpleArray(int size) {
        data = new Object[size];
    }

    public void add(T model) {
        data[length++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, length);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, length);
        System.arraycopy(data, index + 1, data, index, length - 1 - index);
        length--;
    }

    public T get(int index) {
        Objects.checkIndex(index, length);
        return (T) data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<T>(data, length);
    }
}

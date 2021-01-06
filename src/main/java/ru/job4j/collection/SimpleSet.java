package ru.job4j.collection;

import ru.job4j.generics.SimpleArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

    private SimpleArray<E> data;

    public SimpleSet(int size) {
        this.data = new SimpleArray<E>(size);
    }

    public void add(E e) {
        if (!data.contains(e)) {
            data.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }
}

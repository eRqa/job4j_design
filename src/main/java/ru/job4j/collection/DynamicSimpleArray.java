package ru.job4j.collection;

import java.util.*;

public class DynamicSimpleArray<T> implements Iterable<T> {

    private int modCount = 0;
    private int index = 0;
    private Object[] container = new Object[5];

    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return (T) container[index];
    }

    public void add(T model) {
        modCount++;
        if (index == container.length) {
            container = Arrays.copyOf(container, container.length + 10);
        }
        container[index++] = model;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int itIndex = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return itIndex < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[itIndex++];
            }
        };
    }
}
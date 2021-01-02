package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] data;
    private int index = 0;
    private int previousReturnedIndex = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;

        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                result = true;
                index = i;
                break;
            }
        }

        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}

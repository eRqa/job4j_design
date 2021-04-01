package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findBy(value, comparator, (v) -> v < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findBy(value, comparator, (v) -> v > 0);
    }

    private <T> T findBy(List<T> value, Comparator<T> comparator,
                                  Predicate<Integer> predicate) {
        T result = value.get(0);
        for (int i = 0; i < value.size(); i++) {
            T currentValue = value.get(i);
            if (predicate.test(comparator.compare(result, currentValue))) {
                result = currentValue;
            }
        }
        return result;
    }

}
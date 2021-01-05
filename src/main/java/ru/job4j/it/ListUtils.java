package ru.job4j.it;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.nextIndex() == index) {
                iterator.add(value);
                break;
            }
            iterator.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();

        while (iterator.hasNext()) {
            if (iterator.nextIndex() == index) {
                iterator.next();
                iterator.add(value);
                break;
            } else {
                iterator.next();
            }
        }
    }

    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        List<T> deletedItems = new ArrayList<>();
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            T tmp = iterator.next();
            if (filter.test(tmp)) {
                deletedItems.add(tmp);
                iterator.remove();
            }
        }
        return deletedItems;
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        List<T> replacedItems = new ArrayList<>();
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            T tmp = iterator.next();
            if (filter.test(tmp)) {
                replacedItems.add(tmp);
                iterator.set(value);
            }
        }
        return replacedItems;
    }

    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        List<T> deletedItems = new ArrayList<>();
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            T tmp = iterator.next();
            Iterator<T> itElements = elements.iterator();
            while (itElements.hasNext()) {
                if (tmp.equals(itElements.next())) {
                    deletedItems.add(tmp);
                    iterator.remove();
                }
            }
        }
        return deletedItems;
    }

}
package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedSimpleArray<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int modCount = 0;
    private int size = 0;

    public void add(E value) {
        Node<E> node = new Node<>(value, null);

        if (head == null && tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        modCount++;
        size++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> element = head;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int expectedModCount = modCount;
            private Node<E> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                E returnValue = node.item;
                node = node.next;
                return returnValue;
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

}

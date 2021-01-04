package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        Node<T> tmpTail = tail;
        tail.next = node;
        tail = node;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        T currentHeadValue = head.value;
        head = head.next;
        return currentHeadValue;
    }

    public void revert() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<T> currentNode = head;
        Node<T> previous = null;
        Node<T> next;
        while (currentNode != null) {
            next = currentNode.next;
            currentNode.next = previous;
            previous = currentNode;
            currentNode = next;
        }
        head = previous;
    }

    public T deleteLast() {
        if (head == tail) {
            return deleteFirst();
        }

        Node<T> tmpNode = head;
        while (tmpNode.next != tail) {
            tmpNode = tmpNode.next;
        }
        T currentTailValue = tail.value;
        tail = tmpNode;
        return currentTailValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
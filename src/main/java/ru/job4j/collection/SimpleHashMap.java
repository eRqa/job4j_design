package ru.job4j.collection;

import java.util.Map;
import java.util.Objects;

public class SimpleHashMap<K, V> {

    private final Node[] table;
    private final int defaultLength = 16;
    private int currentLength;

    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }
        public final V getValue() {
            return value;
        }
        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Map.Entry) {
                Node<?, ?> e = (Node) o;
                return Objects.equals(key, e.getKey())
                        && Objects.equals(value, e.getValue());
            }
            return false;
        }
    }

    public SimpleHashMap(int length) {
        table = new Node[length];
        currentLength = length;
    }

    public SimpleHashMap() {
        table = new Node[defaultLength];
        currentLength = defaultLength;
    }

    public boolean insert(K key, V value) {

        int keyHashCode = key.hashCode();
        int arrPosition = hash(keyHashCode);

        if (table[arrPosition] != null) {
            return false;
        }

        table[arrPosition] = new Node(keyHashCode, key, value);

        return true;
    }

    public V get(K key) {
        return null;
    }

    public boolean delete(K key) {
        return false;
    }

    private int hash(int hashcode) {
        return hashcode % 16;
    }

}

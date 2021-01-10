package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;

        Optional<Node<E>> optional = findBy(parent);
        if (optional.isEmpty() || findBy(child).isPresent()) {
            return rsl;
        } else {
            optional.get().children.add(new Node<>(child));
            rsl = true;
        }

        return rsl;
    }

    public boolean isBinary() {
        return this.findByPredicate((n) -> n.children.size() > 2).isEmpty();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> predicate) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return this.findByPredicate((n) -> n.value.equals(value));
    }
}
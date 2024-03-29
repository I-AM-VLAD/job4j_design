package ru.job4j.asd.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Node<E> nodeChild = new Node<>(child);
        Node<E> nodeParent;
        Optional<Node<E>> findParent = findBy(parent);
        if (findParent.isPresent() && findBy(child).isEmpty()) {
            nodeParent = findParent.get();
            nodeParent.children.add(nodeChild);
            result = true;
        }
        return result;
    }

    public boolean isBinary() {
        return !findByPredicate(node -> node.children.size() > 2).isPresent();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (condition.test(element)) {
                result = Optional.of(element);
                break;
            }
            data.addAll(element.children);
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
       return findByPredicate(node -> node.value.equals(value));
    }
}
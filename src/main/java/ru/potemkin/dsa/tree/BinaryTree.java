package ru.potemkin.dsa.tree;

import ru.potemkin.dsa.exception.EmptyTreeException;

import java.util.Objects;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree(T value) {
        this.root = new Node<>(value);
    }

    public T min() {
        if (Objects.isNull(root)) {
            throw new EmptyTreeException("BinaryTree is Empty");
        }
        var parent = root;
        var current = root;
        while (Objects.nonNull(current)) {
            parent = current;
            current = parent.leftChild;
        }
        return parent.value;
    }

    public T max() {
        if (Objects.isNull(root)) {
            throw new EmptyTreeException("BinaryTree is Empty");
        }
        var parent = root;
        var current = root;
        while (Objects.nonNull(current)) {
            parent = current;
            current = parent.rightChild;
        }
        return parent.value;
    }

    public boolean find(T value) {
        if (Objects.isNull(root)) {
            throw new EmptyTreeException("BinaryTree is Empty");
        }
        var current = root;
        while (Objects.nonNull(current)) {
            if (value.compareTo(current.value) < 0) {
                current = current.leftChild;
            } else if (value.compareTo(current.value) > 0) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void insert(T value) {
        Node<T> node = new Node<>(value);
        if (root == null) {
            root = node;
        } else {
            var current = root;
            var parent = root;
            while (true) {
                parent = current;
                if (value.compareTo(current.value) < 0) {
                    current = parent.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        break;
                    }
                } else if (value.compareTo(current.value) > 0) {
                    current = parent.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    public boolean delete(T value) {
        //todo
        return false;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    private static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if (value == null) {
                return "{null}";
            }
            var left = leftChild == null ? "" : leftChild.toString();
            var right = rightChild == null ? "" : rightChild.toString();
            return left + "{" + value + "}" + right;
        }
    }
}

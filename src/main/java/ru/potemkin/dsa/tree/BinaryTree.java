package ru.potemkin.dsa.tree;

import ru.potemkin.dsa.exception.EmptyTreeException;

import java.util.Objects;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree(T value) {
        this.root = new Node<>(value);
    }

    public BinaryTree() {
    }

    public T min() {
        if (Objects.isNull(root))
            throw new EmptyTreeException("BinaryTree is Empty");
        var parent = root;
        var current = root;
        while (Objects.nonNull(current)) {
            parent = current;
            current = parent.leftChild;
        }
        return parent.value;
    }

    public T max() {
        if (Objects.isNull(root))
            throw new EmptyTreeException("BinaryTree is Empty");
        var parent = root;
        var current = root;
        while (Objects.nonNull(current)) {
            parent = current;
            current = parent.rightChild;
        }
        return parent.value;
    }

    public boolean find(T value) {
        if (Objects.isNull(root))
            throw new EmptyTreeException("BinaryTree is Empty");
        var current = root;
        while (Objects.nonNull(current)) {
            if (value.compareTo(current.value) < 0)
                current = current.leftChild;
            else if (value.compareTo(current.value) > 0)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void insert(T value) {
        Node<T> node = new Node<>(value);
        if (Objects.isNull(root))
            root = node;
        else {
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
                } else
                    break;
            }
        }
    }

    public boolean delete(T value) {
        if (Objects.isNull(root))
            throw new EmptyTreeException("BinaryTree is Empty");
        var parent = root;
        var current = root;
        var isLeft = true;
        while (Objects.nonNull(current)) {
            if (value.compareTo(current.value) < 0) {
                parent = current;
                current = current.leftChild;
                isLeft = true;
            } else if (value.compareTo(current.value) > 0) {
                parent = current;
                current = current.rightChild;
                isLeft = false;
            } else
                break;
        }

        if (Objects.isNull(current))
            return false;
        if (current.equals(root))
            root = null;
        else if (Objects.isNull(current.leftChild) && (Objects.isNull(current.rightChild))) {
            if (isLeft)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        } else if (Objects.isNull(current.rightChild)) {
            if (isLeft)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        } else if (Objects.isNull(current.leftChild)) {
            if (isLeft)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        } else {
            Node<T> node = findNode(current);
            node.leftChild = current.leftChild;
            node.rightChild = current.rightChild;
            if (isLeft)
                parent.leftChild = node;
            else
                parent.rightChild = node;
        }
        return true;
    }

    private Node<T> findNode(Node<T> node) {
        var current = node.rightChild;
        var parent = current;
        while (Objects.nonNull(current.leftChild)) {
            parent = current;
            current = current.leftChild;
        }
        if (current.equals(node.rightChild))
            node.rightChild = current.rightChild;
        else
            parent.leftChild = current.rightChild;
        return current;
    }

    @Override
    public String toString() {
        return Objects.isNull(root) ? "{}" : root.toString();
    }

    private static class Node<T extends Comparable<T>> {
        private final T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            var left = leftChild == null ? "" : leftChild.toString();
            var right = rightChild == null ? "" : rightChild.toString();
            return left + "{" + value + "}" + right;
        }
    }
}

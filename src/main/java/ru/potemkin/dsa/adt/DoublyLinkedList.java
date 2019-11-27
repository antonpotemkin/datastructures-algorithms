package ru.potemkin.dsa.adt;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import ru.potemkin.dsa.exception.RemoveException;

@ToString
public class DoublyLinkedList<Value extends Comparable<Value>> {
    private Node<Value> first;
    private Node<Value> last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(Value value) {
        var node = new Node<>(value);
        if (!isEmpty()) {
            first.prev = node;
        } else {
            last = node;
        }
        node.next = first;
        first = node;
    }

    public void insertLast(Value value) {
        var node = new Node<>(value);
        if (!isEmpty()) {
            last.next = node;
        } else {
            first = node;
        }
        node.prev = last;
        last = node;
    }

    public Value removeFirst() {
        if (isEmpty()) {
            throw new RemoveException("DoublyLinkedList is empty");
        }
        var temp = first;
        first = first.next;
        if (isEmpty()) {
            last = first;
        } else {
            first.prev = null;
        }
        return temp.value;
    }

    public Value removeLast() {
        if (isEmpty()) {
            throw new RemoveException("DoublyLinkedList is empty");
        }
        var temp = last;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        return temp.value;
    }

    public boolean removeValue(Value value) {
        if (isEmpty()) {
            throw new RemoveException("DoublyLinkedList is empty");
        }
        var current = first;
        var prev = first.prev;
        while (current != null && current.value != value) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == first) {
            removeFirst();
        } else if (current == last) {
            removeLast();
        } else {
            prev.next = current.next;
            current.next.prev = prev;
        }
        return true;
    }

    public boolean insertAfter(Value value) {
        // todo
        return false;
    }

    @ToString
    @RequiredArgsConstructor
    @EqualsAndHashCode
    static class Node<Value extends Comparable<Value>> {
        final Value value;
        Node<Value> next;
        Node<Value> prev;
    }

}

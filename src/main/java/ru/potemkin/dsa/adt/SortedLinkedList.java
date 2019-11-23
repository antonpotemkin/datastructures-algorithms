package ru.potemkin.dsa.adt;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import ru.potemkin.dsa.exception.RemoveException;

@NoArgsConstructor
public class SortedLinkedList<Value extends Comparable<Value>> {
    private Link<Value> first;

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(Value value) {
        var link = new Link<>(value);
        Link<Value> prev = null;
        Link<Value> next = first;
        while (next != null && link.value.compareTo(next.value) > 0) {
            prev = next;
            next = next.next;
        }
        if (prev == null) {
            first = link;
        } else {
            prev.next = link;
        }
        link.next = next;
    }

    public Value remove() {
        if (first == null) {
            throw new RemoveException("SortedList is empty");
        }
        var temp = first;
        first = temp.next;
        return temp.value;
    }

    @ToString
    @RequiredArgsConstructor
    static class Link<Value extends Comparable<Value>> {
        final Value value;
        Link<Value> next;
    }
}

package ru.potemkin.dsa.adt;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import ru.potemkin.dsa.exception.RemoveException;

@NoArgsConstructor
public class LinkedList<Value extends Comparable<Value>> {
    private Link<Value> first;
    private Link<Value> last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(Value value) {
        var link = new Link<>(value);
        if (first == null) {
            last = link;
        } else {
            link.next = first;
        }
        first = link;
    }

    public void insertLast(Value value) {
        var link = new Link<>(value);
        if (last == null) {
            first = link;
        } else {
            last.next = link;
        }
        last = link;
    }

    public Value removeFirst() {
        if (first == null) {
            throw new RemoveException("First is null");
        }
        var temp = first;
        if (temp.next == null) {
            last = null;
        }
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

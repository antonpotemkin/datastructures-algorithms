package ru.potemkin.dsa.hash;

import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

/**
 * HashTable implementation using linked lists for resolving collisions
 */
public class ChainHashTable {

    private final SortedList[] items;
    private final int size;

    public ChainHashTable(int size) {
        this.items = new SortedList[size];
        this.size = size;
        IntStream.range(0, size).forEach(i -> items[i] = new SortedList());
    }

    public void insert(int key, String value) {
        var idx = hash(key);
        items[idx].insert(new Node(key, value));
    }

    public String find(int key) {
        var idx = hash(key);
        Node val = items[idx].find(key);
        return val == null ? null : val.value;
    }

    public String remove(int key) {
        var idx = hash(key);
        Node val = items[idx].remove(key);
        return val == null ? null: val.value;
    }

    private int hash(int key) {
        return key % size;
    }

    private static class SortedList {
        Node first;

        void insert(Node node) {
            Node prev = null;
            Node cur = first;
            while (cur != null && node.key > cur.key) {
                prev = cur;
                cur = cur.next;
            }
            if (prev == null) first = node;
            else prev.next = node;
            node.next = cur;
        }

        Node find(int key) {
            Node cur = first;
            while (cur != null && key >= cur.key) {
                if (key == cur.key) return cur;
                cur = cur.next;
            }
            return null;
        }

        Node remove(int key) {
            Node prev = null;
            Node cur = first;
            while (cur != null && key != cur.key) {
                prev = cur;
                cur = cur.next;
            }
            if (cur == null) return null;
            if (prev == null) first = first.next;
            else prev.next = cur.next;
            return cur;
        }

    }

    @RequiredArgsConstructor
    private static class Node {
        final int key;
        final String value;
        Node next;
    }
}

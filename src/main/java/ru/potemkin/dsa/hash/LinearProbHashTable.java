package ru.potemkin.dsa.hash;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * HashTable implementation using linear probing for resolving collisions
 */
// todo check full/empty table
public class LinearProbHashTable {
    private DataItem[] items;
    private int size;

    public LinearProbHashTable(int size) {
        this.items = new DataItem[size];
        this.size = size;
    }

    public void insert(DataItem item) {
        var idx = hash(item.getKey());
        var curItem = items[idx];
        while (curItem != null && curItem.getKey() != -1) {
            idx += 1;
            idx %= size;
            curItem = items[idx % size];
        }
        items[idx] = item;
    }

    public String find(int key){
        var idx = hash(key);
        var curItem = items[idx];
        while (curItem != null) {
            if (curItem.getKey() == key) return curItem.getValue();
            idx += 1;
            idx %= size;
            curItem = items[idx % size];
        }
        return null;
    }

    public DataItem remove(int key) {
        var idx = hash(key);
        var curItem = items[idx];
        while (curItem != null) {
            if (curItem.getKey() == key) {
                items[idx] = new DataItem(-1, null);
                return curItem;
            }
            idx += 1;
            idx %= size;
            curItem = items[idx % size];
        }
        return null;
    }

    private int hash(int key) {
        return key % size;
    }

    @Override
    public String toString() {
        List<DataItem> filtered = Stream.of(items).filter(Objects::nonNull).collect(Collectors.toList());
        return "LinearProbHashTable{" +
                "items=" + filtered +
                '}';
    }
}

package ru.potemkin.dsa.hash;

import ru.potemkin.dsa.model.DataItem;

/**
 * HashTable implementation using linear probing for resolving collisions
 */
// todo check full/empty table
public class LinearProbHashTable extends AbstractHashTable {

    public LinearProbHashTable(int size) {
        super(size);
    }

    @Override
    public void insert(DataItem item) {
        var idx = hash(item.getKey());
        var curItem = items[idx];
        while (curItem != null && curItem.getKey() != -1) {
            idx += 1;
            idx %= size;
            curItem = items[idx];
        }
        items[idx] = item;
    }

    @Override
    public String find(int key){
        var idx = hash(key);
        var curItem = items[idx];
        while (curItem != null) {
            if (curItem.getKey() == key) return curItem.getValue();
            idx += 1;
            idx %= size;
            curItem = items[idx];
        }
        return null;
    }

    @Override
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
            curItem = items[idx];
        }
        return null;
    }

    private int hash(int key) {
        return key % size;
    }
}

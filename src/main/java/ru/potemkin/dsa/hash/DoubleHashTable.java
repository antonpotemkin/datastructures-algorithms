package ru.potemkin.dsa.hash;

/**
 * HashTable implementation using double hashing for resolving collisions
 */
// todo check full/empty table
public class DoubleHashTable extends AbstractHashTable {
    public DoubleHashTable(int size) {
        super(size);
    }

    @Override
    void insert(DataItem item) {
        var idx = hash(item.getKey());
        var stepSize = hashStep(item.getKey());
        var curItem = items[idx];
        while (curItem != null && curItem.getKey() != -1) {
            idx += stepSize;
            idx %= size;
            curItem = items[idx];
        }
        items[idx] = item;
    }

    @Override
    String find(int key) {
        var idx = hash(key);
        var stepSize = hashStep(key);
        var curItem = items[idx];
        while (curItem != null) {
            if (curItem.getKey() == key) return curItem.getValue();
            idx += stepSize;
            idx %= size;
            curItem = items[idx];
        }
        return null;
    }

    @Override
    DataItem remove(int key) {
        var idx = hash(key);
        var stepSize = hashStep(key);
        var curItem = items[idx];
        while (curItem != null) {
            if (curItem.getKey() == key) {
                items[idx] = new DataItem(-1, null);
                return curItem;
            }
            idx += stepSize;
            idx %= size;
            curItem = items[idx];
        }
        return null;
    }

    private int hash(int key) {
        return key % size;
    }

    private int hashStep(int key) {
        var step = 5; //simple integer
        return step - (key % step);
    }
}

package ru.potemkin.dsa.hash;

import ru.potemkin.dsa.model.DataItem;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractHashTable {

    protected DataItem[] items;
    protected int size;

    public AbstractHashTable(int size) {
        this.items = new DataItem[size];
        this.size = size;
    }

    abstract void insert(DataItem item);
    abstract String find(int key);
    abstract DataItem remove(int key);

    @Override
    public String toString() {
        List<DataItem> filtered = Stream.of(items).filter(Objects::nonNull).collect(Collectors.toList());
        return  getClass().getSimpleName() + "{" +
                "items=" + filtered +
                '}';
    }

}

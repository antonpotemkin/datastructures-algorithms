package ru.potemkin.dsa.hash;

public class DataItem {
    private final int key;
    private final String value;

    public DataItem(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}

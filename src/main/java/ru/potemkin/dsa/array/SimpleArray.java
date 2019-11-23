package ru.potemkin.dsa.array;

import ru.potemkin.dsa.exception.InsertException;

import java.util.Arrays;

public class SimpleArray {
    private int[] arr;
    private int max;
    private int size;

    public SimpleArray(int max) {
        this.arr = new int[max];
        this.max = max;
    }

    public void insert(int value) {
        if (size == max) {
            throw new InsertException("SimpleArray is full");
        }
        this.arr[size++] = value;
    }

    public boolean find(int value) {
        int i;
        for (i = 0; i < max; i++) {
            if (this.arr[i] == value) {
                break;
            }
        }
        return i != max;
    }

    public boolean delete(int value) {
        int j = 0;
        for (j = 0; j < size; j++) {
            if (arr[j] == value) {
                break;
            }
        }
        if (j == size) {
            return false;
        }
        for (int i = j; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public String toString() {
        return "SimpleArray{" +
                "arr=" + Arrays.toString(Arrays.copyOf(arr, size)) +
                '}';
    }
}

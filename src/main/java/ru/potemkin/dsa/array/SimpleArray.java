package ru.potemkin.dsa.array;

import java.util.Arrays;

public class SimpleArray {
    private int[] arr;
    private int size;

    public SimpleArray(int max, int size) {
        this.arr = new int[max];
        this.size = size;
    }

    public void insert(int value) {
        this.arr[size] = value;
        size++;
    }

    boolean find(int value) {
        int i;
        for (i = 0; i < size; i++) {
            if (this.arr[i] == value) {
                break;
            }
        }
        return i != size;
    }

    boolean delete(int value) {
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

    public String display() {
        return Arrays.toString(Arrays.copyOf(arr, size));
    }
}

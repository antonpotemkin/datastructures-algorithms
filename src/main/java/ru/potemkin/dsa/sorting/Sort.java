package ru.potemkin.dsa.sorting;

/**
 * Base class for sorting
 */
public abstract class Sort {

    protected int[] mas;

    public Sort(int[] mas) {
        this.mas = mas;
    }

    void swap(int i, int j) {
        int temp = mas[i];
        mas[i] = mas[j];
        mas[j] = temp;
    }

    public int[] getMas() {
        return mas;
    }

    public abstract void sort();
}

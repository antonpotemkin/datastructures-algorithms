package ru.potemkin.dsa.sorting;

abstract class Sort {

    int[] mas;

    Sort(int[] mas) {
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

    abstract void sort();

}

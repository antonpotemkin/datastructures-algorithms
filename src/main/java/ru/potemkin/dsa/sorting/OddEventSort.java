package ru.potemkin.dsa.sorting;

public class OddEventSort extends Sort {
    public OddEventSort(int[] mas) {
        super(mas);
    }

    @Override
    public void sort() {
        var isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < mas.length - 1; i+=2) {
                if (mas[i] > mas[i + 1]) {
                    swap(i, i + 1);
                    isSorted = false;
                }
            }
            for (int i = 0; i < mas.length - 1; i+=2) {
                if (mas[i] > mas[i + 1]) {
                    swap(i, i + 1);
                    isSorted = false;
                }
            }
        }
    }
}

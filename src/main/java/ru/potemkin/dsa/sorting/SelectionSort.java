package ru.potemkin.dsa.sorting;

public class SelectionSort extends Sort {

    public SelectionSort(int[] mas) {
        super(mas);
    }

    @Override
    public void sort() {
        for (var i = 0; i < mas.length - 1; i++) {
            var min = i;
            for (var j = i + 1; j < mas.length; j++) {
                if (mas[j] < mas[min])
                    min = j;
            }
            if (min != i)
                swap(i, min);
        }
    }
}

package ru.potemkin.dsa.sorting;

public class BubbleSort extends Sort {

    public BubbleSort(int[] mas) {
        super(mas);
    }

    @Override
    public void sort() {
        var isSorted = true;
        for (var i = mas.length - 1; i > 1; i--) {
            isSorted = true;
            for (var j = 0; j < i; j++) {
                if (mas[j] > mas[j + 1]) {
                    swap(j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

}

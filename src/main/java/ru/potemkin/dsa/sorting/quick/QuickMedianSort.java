package ru.potemkin.dsa.sorting.quick;

import ru.potemkin.dsa.sorting.Sort;

public class QuickMedianSort extends Sort {

    public QuickMedianSort(int[] mas) {
        super(mas);
    }

    @Override
    public void sort() {
        quickSort(0, mas.length - 1);
    }

    private void quickSort(int left, int right) {
        var size = right - left + 1;
        if (size <= 3)
            manualSort(left, right, size);
        else {
            var pivot = median(left, right);
            var partition = partition(left, right, pivot);
            quickSort(left, partition - 1);
            quickSort(partition + 1, right);
        }
    }

    private int partition(int left, int right, int pivot) {
        var leftPtr = left;
        var rightPtr = right - 1;
        while (true) {
            while (mas[++leftPtr] < pivot) { }
            while (mas[--rightPtr] > pivot) { }
            if (leftPtr >= rightPtr)
                break;
            swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    private int median(int left, int right) {
        var med = (right + left) / 2;
        sortThreeElements(left,med,right);
        swap(med, right - 1);
        return mas[right - 1];
    }

    private void sortThreeElements(int left, int med, int right) {
        if (mas[left] > mas[med])
            swap(left, med);
        if (mas[left] > mas[right])
            swap(left, right);
        if (mas[med] > mas[right])
            swap(med, right);
    }

    private void manualSort(int left, int right, int size) {
        if (size == 2) {
            if (mas[left] > mas[right])
                swap(left, right);
        } else if (size == 3)
            sortThreeElements(left, left + 1, right);
    }

    private void swap(int left, int right) {
        var temp = mas[left];
        mas[left] = mas[right];
        mas[right] = temp;
    }
}

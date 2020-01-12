package ru.potemkin.dsa.sorting.quick;

import ru.potemkin.dsa.sorting.Sort;

public class QuickSort extends Sort {

    public QuickSort(int[] mass) {
        super(mass);
    }

    @Override
    public void sort() {
        quickSort(0, mas.length - 1);
    }

    private void quickSort(int left, int right) {
        var size = right - left + 1;
        if (size > 1) {
            var pivot = mas[right];
            var partition = partition(left, right, pivot);
            quickSort(left, partition - 1);
            quickSort(partition + 1, right);
        }
    }

    private int partition(int left, int right, int pivot) {
        var leftPtr = left - 1;
        var rightPtr = right;
        while (true) {
            while (mas[++leftPtr] < pivot) {
            }
            while (rightPtr > left && mas[--rightPtr] > pivot) {
            }
            if (leftPtr >= rightPtr) {
                break;
            }
            swap(leftPtr,rightPtr);
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    private void swap(int left, int right) {
        var temp = mas[left];
        mas[left] = mas[right];
        mas[right] = temp;
    }
}

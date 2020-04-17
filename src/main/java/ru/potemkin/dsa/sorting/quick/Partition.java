package ru.potemkin.dsa.sorting.quick;

public class Partition {
    int[] mas;
    int size;

    public Partition(int size) {
        this.mas = new int[size];
        this.size = 0;
    }

    public void insert(int value) {
        mas[size++] = value;
    }

    public int partition(int pivot) {
        var leftPtr = -1;
        var rightPtr = size;
        while (true) {
            while (leftPtr < size - 1 && mas[++leftPtr] < pivot) { }
            while (rightPtr > 0 && mas[--rightPtr] >= pivot) { }
            if (leftPtr >= rightPtr) break;
            swap(leftPtr,rightPtr);
        }
        return leftPtr;
    }

    private void swap(int left, int right) {
        var temp = mas[left];
        mas[left] = mas[right];
        mas[right] = temp;
    }
}

package ru.potemkin.dsa.search;

public class BinarySearch implements Search {
    @Override
    public int search(int[] massive, int key) {
        var low = 0;
        var high = massive.length - 1;
        while (low <= high) {
            var mid = (low + high)/2;
            var number = massive[mid];
            if (number < key) {
                low = mid + 1;
            } else if (number > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

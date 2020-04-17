package ru.potemkin.dsa.sorting;

public class MergeSort extends Sort {
    MergeSort(int[] mas) {
        super(mas);
    }

    @Override
    public void sort() {
        mas = innerSort(0, mas.length - 1);
    }

    private int[] innerSort(int low, int end) {
        if (low == end)
            return new int[]{mas[low]};
        if (low > end)
            return new int[0];
        var mid = (end + low) / 2;
        var left = innerSort(low, mid);
        var right = innerSort(mid + 1, end);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        var result = new int[left.length + right.length];
        var i = 0;
        var l = 0;
        var r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r])
                result[i++] = left[l++];
            else
                result[i++] = right[r++];
        }
        while (l < left.length)
            result[i++] = left[l++];
        while (r < right.length)
            result[i++] = right[r++];
        return result;
    }
}

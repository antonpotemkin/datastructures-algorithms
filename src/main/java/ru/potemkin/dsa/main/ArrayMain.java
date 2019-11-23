package ru.potemkin.dsa.main;

import ru.potemkin.dsa.array.SimpleArray;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class ArrayMain {
    public static void main(String[] args) {
        var random = new Random(7);
        var left = new int[15];
        for (var i = 0; i < left.length; i++) {
            left[i] = random.nextInt(100);
        }
        Arrays.sort(left);
        var right = new int[10];
        for (var i = 0; i < right.length; i++) {
            right[i] = random.nextInt(100);
        }
        Arrays.sort(right);
        SimpleArray merge = merge(left, right);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        System.out.println(merge);

        var mass = new Integer[100];
        for (var i = 0; i < mass.length; i++) {
            mass[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(mass));
        System.out.println(noDups(mass));
    }

    public static SimpleArray merge(int[] left, int[] right) {
        var l = 0;
        var r = 0;
        var result = new SimpleArray(left.length + right.length);
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                result.insert(left[l]);
                l++;
            } else {
                result.insert(right[r]);
                r++;
            }

        }
        if (l == left.length) {
            for (int j = r; j < right.length; j++) {
                result.insert(right[j]);
            }
        } else if (r == right.length) {
            for (int j = l; j < left.length; j++) {
                result.insert(left[j]);
            }
        }
        return result;
    }

    public static SimpleArray noDups(Integer[] mass) {
        for (var i = 0; i < mass.length; i++) {
            for (var j = 0; j < mass.length; j++) {
                if (i == j) {
                    continue;
                }
                if (Objects.equals(mass[i], mass[j])) {
                    mass[j] = null;
                }
            }
        }
        SimpleArray result = new SimpleArray(mass.length);
        for (var i = 0; i < mass.length; i++) {
            if (mass[i] != null) {
                result.insert(mass[i]);
            }
        }
        return result;
    }


}

package ru.potemkin.dsa;

import java.util.Random;

public class TestUtil {

    private TestUtil() {
    }

    public static int[] getMassive(int length, int maxNumber) {
        var mas = new int[length];
        var random = new Random();
        for (int i = 0; i < length; i++) {
            mas[i] = random.nextInt(maxNumber);
        }
        return mas;
    }

    public static int getRandom(int number) {
        var random = new Random();
        return random.nextInt(number);
    }
}

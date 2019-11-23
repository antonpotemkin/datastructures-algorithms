package ru.potemkin.dsa.sorting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ru.potemkin.dsa.TestUtil.getMassive;

public class MedianaTest {
    private static final int LENGTH_MASSIVE = 10;
    private static final int MAX_NUMBER = 10;
    private static int[] massive;

    @BeforeAll
    public static void setUp() {
        massive = getMassive(LENGTH_MASSIVE, MAX_NUMBER);
    }

    @Test
    public void medianaTest() {
        var sort = new InsertionSort(new int[LENGTH_MASSIVE]);
        System.arraycopy(massive, 0, sort.getMas(), 0, LENGTH_MASSIVE);
        sort.sort();
        System.out.println(Arrays.toString(sort.mas));
        System.out.println(sort.mediana());
    }
}

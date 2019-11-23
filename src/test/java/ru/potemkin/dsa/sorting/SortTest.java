package ru.potemkin.dsa.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ru.potemkin.dsa.TestUtil.getMassive;

public class SortTest {
    private static final int LENGTH_MASSIVE = 1000;
    private static final int MAX_NUMBER = 3000;
    private static int[] massive;
    private static int[] sortedMassive;

    @BeforeAll
    public static void setUp() throws Exception {
        massive = getMassive(LENGTH_MASSIVE, MAX_NUMBER);
        sortedMassive = new int[LENGTH_MASSIVE];
        System.arraycopy(massive, 0, sortedMassive, 0, LENGTH_MASSIVE);
        Arrays.sort(sortedMassive);
    }

    @Test
    public void testBubbleSort() {
        var sort = new BubbleSort(new int[LENGTH_MASSIVE]);
        System.arraycopy(massive, 0, sort.getMas(), 0, LENGTH_MASSIVE);
        sort.sort();
        Assertions.assertArrayEquals(sortedMassive, sort.getMas());
    }

    @Test
    public void testInsertionSort() {
        var sort = new InsertionSort(new int[LENGTH_MASSIVE]);
        System.arraycopy(massive, 0, sort.getMas(), 0, LENGTH_MASSIVE);
        sort.sort();
        Assertions.assertArrayEquals(sortedMassive, sort.getMas());
    }

    @Test
    public void testInsertionSortArrayCopy() {
        var sort = new InsertionSort(new int[LENGTH_MASSIVE]);
        System.arraycopy(massive, 0, sort.getMas(), 0, LENGTH_MASSIVE);
        sort.sortArraycopy();
        Assertions.assertArrayEquals(sortedMassive, sort.getMas());
    }

    @Test
    public void testSelectionSort() {
        var sort = new SelectionSort(new int[LENGTH_MASSIVE]);
        System.arraycopy(massive, 0, sort.getMas(), 0, LENGTH_MASSIVE);
        sort.sort();
        Assertions.assertArrayEquals(sortedMassive, sort.getMas());
    }

    @Test
    public void testOddEventSort() {
        var sort = new OddEventSort(new int[LENGTH_MASSIVE]);
        System.arraycopy(massive, 0, sort.getMas(), 0, LENGTH_MASSIVE);
        sort.sort();
        Assertions.assertArrayEquals(sortedMassive, sort.getMas());
    }

}

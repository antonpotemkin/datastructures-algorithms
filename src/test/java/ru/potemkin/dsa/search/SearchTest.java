package ru.potemkin.dsa.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ru.potemkin.dsa.TestUtil.getMassive;
import static ru.potemkin.dsa.TestUtil.getRandom;

public class SearchTest {

    private static final int LENGTH_MASSIVE = 1000;
    private static final int MAX_NUMBER = 3000;
    private static int[] massive;


    @BeforeAll
    public static void setUp() throws Exception {
        massive = getMassive(LENGTH_MASSIVE, MAX_NUMBER);
        Arrays.sort(massive);
    }

    @Test
    public void testLinearSearch() {
        Search search = new LinearSearch();
        var number = massive[getRandom(LENGTH_MASSIVE)];
        var expected = Arrays.binarySearch(massive,number);
        var actual = search.search(massive, number);
        Assertions.assertEquals(expected, actual);
        var negativeResult = search.search(massive, MAX_NUMBER + 1);
        Assertions.assertEquals(-1, negativeResult);
    }
    @Test
    public void testBinarySearch() {
        var search = new BinarySearch();
        for (int i = 0; i < 1000; i ++) {
            var number = massive[getRandom(LENGTH_MASSIVE)];
            var expected = Arrays.binarySearch(massive,number);
            var actual = search.search(massive, number);
            Assertions.assertEquals(expected, actual);
        }
        var negativeResult = search.search(massive, MAX_NUMBER + 1);
        Assertions.assertEquals(-1, negativeResult);
    }

}

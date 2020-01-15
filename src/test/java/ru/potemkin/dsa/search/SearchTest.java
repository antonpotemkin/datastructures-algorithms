package ru.potemkin.dsa.search;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static ru.potemkin.dsa.TestUtil.getMassive;
import static ru.potemkin.dsa.TestUtil.getRandom;

public class SearchTest {

    private static final int LENGTH_MASSIVE = 1000;
    private static final int MAX_NUMBER = 3000;
    private static int[] massive;

    @BeforeEach
    public void setUp() {
        massive = getMassive(LENGTH_MASSIVE, MAX_NUMBER);
        Arrays.sort(massive);
    }

    @RepeatedTest(100)
    public void testLinearSearch() {
        Search search = new LinearSearch();
        var number = massive[getRandom(LENGTH_MASSIVE)];
        var expected = Arrays.binarySearch(massive, number);
        var actual = search.search(massive, number);
        Assertions.assertEquals(massive[expected], massive[actual]);
        var negativeResult = search.search(massive, MAX_NUMBER + 1);
        Assertions.assertEquals(-1, negativeResult);
    }

    @RepeatedTest(100)
    public void testBinarySearch() {
        var search = new BinarySearch();
        var number = massive[getRandom(LENGTH_MASSIVE)];
        var expected = Arrays.binarySearch(massive, number);
        var actual = search.search(massive, number);
        Assertions.assertEquals(expected, actual);
        var negativeResult = search.search(massive, MAX_NUMBER + 1);
        Assertions.assertEquals(-1, negativeResult);
    }

}

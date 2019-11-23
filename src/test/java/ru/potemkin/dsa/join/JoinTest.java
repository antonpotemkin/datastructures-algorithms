package ru.potemkin.dsa.join;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JoinTest {
    private Join nestedLoopsJoin = new NestedLoopsJoin();
    private Join hashJoin =  new HashJoin();
    private Join mergeJoin = new MergeJoin();
    private static List<Pair<Long, String>> left = new ArrayList<>();
    private static List<Pair<Long, String>> right = new ArrayList<>();
    private static List<Triple<Long, String, String>> result = new ArrayList<>();

    @BeforeAll
    public static void after() {
        for (long i = 1; i < 20; i += 2) {
            left.add(new Pair<>(i, "v1, k = " + i));
            right.add(new Pair<>(i, "v2, k = " + i));
        }
        for (long i = 2; i < 20; i += 4) {
            left.add(new Pair<>(i, "v1, k = " + i));
        }
        for (long i = 4; i < 20; i += 4) {
            right.add(new Pair<>(i, "v2, k = " + i));
        }
        for (long i = 1; i < 20; i += 2) {
            result.add(new Triple<>(i, "v1, k = " + i, "v2, k = " + i));
        }
    }

    @Test
    public void join() {
        Assertions.assertEquals(result, nestedLoopsJoin.join(left, right));
        Assertions.assertEquals(result, hashJoin.join(left, right));
        Assertions.assertEquals(result, mergeJoin.join(left, right));
    }
}
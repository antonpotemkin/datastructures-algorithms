package ru.potemkin.dsa.sorting.quick;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class PartitionTest {
    int size = 100;
    Partition partition;

    @BeforeEach
    public void setUp() {
        partition = new Partition(size);
        Random r = new Random();
        IntStream.generate(() -> r.nextInt(1000)).limit(size).forEach((int value) -> partition.insert(value));
    }

    @RepeatedTest(2)
    public void partition() {
        int pivot = 400;
        int partition = this.partition.partition(pivot);
        long right = Arrays.stream(this.partition.mas).dropWhile((int element) -> element < pivot).count();
        assertEquals(partition, size - right);
    }
}
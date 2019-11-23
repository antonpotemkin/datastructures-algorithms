package ru.potemkin.dsa.adt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.potemkin.dsa.exception.InsertException;
import ru.potemkin.dsa.exception.RemoveException;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {
    private PriorityQueue priorityQueue;

    @BeforeEach
    void setUp() {
        priorityQueue = new PriorityQueue(5);
    }

    @Test
    public void test() {
        priorityQueue.inQueue(10);
        priorityQueue.inQueue(4);
        priorityQueue.inQueue(9);
        assertEquals(4, priorityQueue.deQueue());
        assertEquals(9, priorityQueue.deQueue());
        priorityQueue.inQueue(11);
        assertEquals(10, priorityQueue.deQueue());
        priorityQueue.inQueue(5);
        priorityQueue.inQueue(66);
        priorityQueue.inQueue(77);
        priorityQueue.inQueue(88);
        assertFalse(priorityQueue.isEmpty());
        assertTrue(priorityQueue.isFull());
        assertThrows(InsertException.class, () -> priorityQueue.inQueue(99));
        assertEquals(5, priorityQueue.deQueue());
        assertEquals(11, priorityQueue.deQueue());
        assertEquals(66, priorityQueue.deQueue());
        assertEquals(77, priorityQueue.deQueue());
        assertEquals(88, priorityQueue.deQueue());
        assertTrue(priorityQueue.isEmpty());
        assertFalse(priorityQueue.isFull());
        assertThrows(RemoveException.class, () -> priorityQueue.deQueue());
    }
}

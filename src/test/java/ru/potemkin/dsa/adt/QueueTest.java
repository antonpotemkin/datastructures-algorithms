package ru.potemkin.dsa.adt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.potemkin.dsa.exception.InsertException;
import ru.potemkin.dsa.exception.RemoveException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue(5);
    }

    @Test
    public void test() {
        queue.inQueue(10);
        queue.inQueue(4);
        queue.inQueue(9);
        assertEquals(10, queue.deQueue());
        assertEquals(4, queue.deQueue());
        queue.inQueue(11);
        assertEquals(9, queue.deQueue());
        queue.inQueue(5);
        queue.inQueue(66);
        queue.inQueue(77);
        queue.inQueue(88);
        assertFalse(queue.isEmpty());
        assertTrue(queue.isFull());
        assertThrows(InsertException.class, () -> queue.inQueue(99));
        assertEquals(11, queue.deQueue());
        assertEquals(5, queue.deQueue());
        assertEquals(66, queue.deQueue());
        assertEquals(77, queue.deQueue());
        assertEquals(88, queue.deQueue());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        assertThrows(RemoveException.class, () -> queue.deQueue());
    }
}
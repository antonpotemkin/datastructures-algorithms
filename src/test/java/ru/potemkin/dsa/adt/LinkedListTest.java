package ru.potemkin.dsa.adt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.potemkin.dsa.exception.RemoveException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>();
    }

    @Test
    public void test() {
        assertTrue(linkedList.isEmpty());
        linkedList.insertFirst(10);
        linkedList.insertLast(2);
        linkedList.insertLast(40);
        linkedList.insertFirst(5);
        linkedList.insertFirst(19);
        assertEquals(19, linkedList.removeFirst());
        assertEquals(5, linkedList.removeFirst());
        assertEquals(10, linkedList.removeFirst());
        assertEquals(2, linkedList.removeFirst());
        assertEquals(40, linkedList.removeFirst());
        assertTrue(linkedList.isEmpty());
        assertThrows(RemoveException.class, () -> linkedList.removeFirst());
    }
}
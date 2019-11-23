package ru.potemkin.dsa.adt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.potemkin.dsa.exception.RemoveException;

import static org.junit.jupiter.api.Assertions.*;

class SortedLinkedListTest {
    private SortedLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SortedLinkedList<>();
    }

    @Test
    public void test() {
        assertTrue(list.isEmpty());
        list.insert(10);
        list.insert(2);
        list.insert(40);
        list.insert(5);
        list.insert(19);
        list.insert(1);
        assertEquals(1, list.remove());
        assertEquals(2, list.remove());
        assertEquals(5, list.remove());
        assertEquals(10, list.remove());
        assertEquals(19, list.remove());
        assertEquals(40, list.remove());
        assertTrue(list.isEmpty());
        assertThrows(RemoveException.class, () -> list.remove());
    }
}
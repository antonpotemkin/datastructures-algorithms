package ru.potemkin.dsa.adt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.potemkin.dsa.exception.RemoveException;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    private DoublyLinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new DoublyLinkedList<>();
    }

    @Test
    public void emptyTest() {
        assertTrue(linkedList.isEmpty());
        assertThrows(RemoveException.class, () -> linkedList.removeFirst());
        assertThrows(RemoveException.class, () -> linkedList.removeLast());
        assertThrows(RemoveException.class, () -> linkedList.removeValue(11));
    }

    @Test
    public void firstAndLastTest() {
        linkedList.insertFirst(10);
        assertEquals(10, linkedList.removeFirst());
        linkedList.insertFirst(10);
        assertEquals(10, linkedList.removeLast());
        linkedList.insertLast(40);
        assertEquals(40, linkedList.removeFirst());
        linkedList.insertLast(40);
        assertEquals(40, linkedList.removeLast());
    }

    @Test
    public void removeValueTest() {
        assertThrows(RemoveException.class, () -> linkedList.removeValue(0));
        linkedList.insertFirst(10);
        assertTrue(linkedList.removeValue(10));
        linkedList.isEmpty();
        linkedList.insertLast(10);
        linkedList.insertFirst(20);
        linkedList.insertFirst(30);
        linkedList.insertLast(40);
        assertFalse(linkedList.removeValue(22));
        assertTrue(linkedList.removeValue(20));
        assertTrue(linkedList.removeValue(30));
        assertFalse(linkedList.isEmpty());
        assertTrue(linkedList.removeValue(40));
        assertTrue(linkedList.removeValue(10));
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void insertAfterTest() {
        assertThrows(RemoveException.class, () -> linkedList.removeValue(0));
        linkedList.insertLast(10);
        assertFalse(linkedList.insertAfter(11, 11));
        assertTrue(linkedList.insertAfter(10, 11));
        linkedList.insertLast(12);
        linkedList.insertLast(13);
        assertTrue(linkedList.insertAfter(10, 14));
        assertTrue(linkedList.insertAfter(13, 15));
        assertEquals(10, linkedList.removeFirst());
        assertEquals(14, linkedList.removeFirst());
        assertEquals(11, linkedList.removeFirst());
        assertEquals(12, linkedList.removeFirst());
        assertEquals(13, linkedList.removeFirst());
        assertEquals(15, linkedList.removeFirst());
        assertTrue(linkedList.isEmpty());
    }

}
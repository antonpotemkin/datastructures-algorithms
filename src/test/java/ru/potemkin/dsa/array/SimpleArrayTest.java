package ru.potemkin.dsa.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.potemkin.dsa.exception.InsertException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayTest {
    private SimpleArray array;

    @BeforeEach
    void setUp() {
        array = new SimpleArray(5);
    }

    @Test
    public void test() {
        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);
        array.insert(10);
        assertThrows(InsertException.class, () -> array.insert(5));
        assertTrue(array.find(3));
        assertTrue(array.find(10));
        assertFalse(array.find(5));
        assertTrue(array.delete(4));
        assertFalse(array.delete(11));
        assertFalse(array.find(4));
        assertTrue(array.find(2));
    }
}
package ru.potemkin.dsa.pyramid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.potemkin.dsa.exception.RemoveException;
import ru.potemkin.dsa.model.DataItem;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PyramidTest {
    private Pyramid pyramid = new Pyramid(7);

    @BeforeEach
    public void setUp() {
        pyramid.insert(new DataItem(10, "1"));
        pyramid.insert(new DataItem(2, "2"));
        pyramid.insert(new DataItem(11, "11"));
        pyramid.insert(new DataItem(99, "99"));
        pyramid.insert(new DataItem(5, "5"));
    }

    @Test
    public void test() {
        assertEquals("99", pyramid.remove().getValue());
        assertTrue(pyramid.insert(new DataItem(101, "101")));
        assertTrue(pyramid.insert(new DataItem(66, "66")));
        assertTrue(pyramid.insert(new DataItem(77, "77")));
        assertFalse(pyramid.insert(new DataItem(0,"0")));
    }

    @Test
    public void testEmpty() {
        pyramid = new Pyramid(1);
        assertThrows(RemoveException.class, () -> pyramid.remove());
    }
}
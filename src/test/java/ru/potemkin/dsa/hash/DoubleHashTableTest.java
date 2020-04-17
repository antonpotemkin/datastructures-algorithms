package ru.potemkin.dsa.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.potemkin.dsa.model.DataItem;

import static org.junit.jupiter.api.Assertions.*;

class DoubleHashTableTest {
    private DoubleHashTable table;

    @BeforeEach
    public void setUp() {
        table = new DoubleHashTable(11);
        table.insert(new DataItem(22, "Value22"));
        table.insert(new DataItem(25, "Value25"));
        table.insert(new DataItem(44, "Value44"));
        table.insert(new DataItem(67, "Value67"));
        table.insert(new DataItem(99, "Value99"));
    }

    @Test
    public void mainTest() {
        assertEquals("Value67", table.find(67));
        table.insert(new DataItem(88, "Value88"));
        table.insert(new DataItem(79, "Value79"));
        assertEquals("Value99", table.find(99));
        assertEquals("Value88", table.find(88));
        assertEquals("Value79", table.find(79));
        assertEquals("Value99",table.remove(99).getValue());
        assertNull(table.find(99));
        table.insert(new DataItem(9, "Value9"));
        assertEquals("Value9", table.find(9));
        assertEquals("Value22", table.find(22));
        assertEquals("Value25", table.find(25));
        assertEquals("Value44", table.find(44));
        assertEquals("Value67", table.find(67));
        assertEquals("Value88", table.find(88));
        assertEquals("Value79", table.find(79));
    }
}
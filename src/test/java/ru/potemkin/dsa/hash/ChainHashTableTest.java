package ru.potemkin.dsa.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainHashTableTest {
    private ChainHashTable table;
    @BeforeEach
    public void setUp() {
        table = new ChainHashTable(11);
        table.insert(22, "Value22");
        table.insert(25, "Value25");
        table.insert(44, "Value44");
        table.insert(67, "Value67");
        table.insert(99, "Value99");
    }

    @Test
    public void mainTest() {
        assertEquals("Value67", table.find(67));
        table.insert(88, "Value88");
        table.insert(79, "Value79");
        assertEquals("Value99", table.find(99));
        assertEquals("Value88", table.find(88));
        assertEquals("Value79", table.find(79));
        assertEquals("Value99",table.remove(99));
        assertNull(table.find(99));
        table.insert(9, "Value9");
        assertEquals("Value9", table.find(9));
        assertEquals("Value22", table.find(22));
        assertEquals("Value25", table.find(25));
        assertEquals("Value44", table.find(44));
        assertEquals("Value67", table.find(67));
        assertEquals("Value88", table.find(88));
        assertEquals("Value79", table.find(79));
    }

}
package ru.potemkin.dsa.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.potemkin.dsa.model.DataItem;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LinearProbHashTableTest {
    private LinearProbHashTable table;

    @BeforeEach
    public void setUp() {
        table = new LinearProbHashTable(11);
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
        table.insert(new DataItem(19, "Value19"));
        table.insert(new DataItem(9, "Value9"));
        assertEquals("Value9", table.find(9));
        assertEquals("Value19", table.find(19));
        String sub = "DataItem(key=79, value=Value79), DataItem(key=19, value=Value19), DataItem(key=9, value=Value9)]}";
        System.out.println(table.toString());
        assertTrue(table.toString().endsWith(sub));
    }


}
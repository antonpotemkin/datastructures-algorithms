package ru.potemkin.dsa.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LinearProbHashTableTest {
    LinearProbHashTable table;

    @BeforeEach
    public void setUp() {
        table = new LinearProbHashTable(10);
        table.insert(new DataItem(22, "Value22"));
        table.insert(new DataItem(25, "Value25"));
        table.insert(new DataItem(44, "Value44"));
        table.insert(new DataItem(67, "Value67"));
        table.insert(new DataItem(99, "Value99"));
    }

    @Test
    public void findTest() {
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
        String expected = "LinearProbHashTable{items=[DataItem{key=79, value='Value79'}, DataItem{key=22, value='Value22'}, DataItem{key=44, value='Value44'}, DataItem{key=25, value='Value25'}, DataItem{key=67, value='Value67'}, DataItem{key=88, value='Value88'}, DataItem{key=9, value='Value9'}]}";
        assertEquals(expected, table.toString());
    }


}
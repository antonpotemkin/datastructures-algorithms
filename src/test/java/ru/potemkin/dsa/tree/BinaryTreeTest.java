package ru.potemkin.dsa.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.potemkin.dsa.exception.EmptyTreeException;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private BinaryTree<Integer> root;

    @BeforeEach
    public void setUp() {
        root = new BinaryTree<>(50);
        root.insert(30);
        root.insert(70);
        root.insert(20);
        root.insert(40);
        root.insert(10);
        root.insert(25);
        root.insert(5);
        root.insert(45);
        root.insert(65);
        root.insert(80);
        root.insert(90);
        root.insert(67);
        root.insert(66);
    }

    @Test
    public void emptyTest() {
        root = new BinaryTree<Integer>();
        assertThrows(EmptyTreeException.class, root::max);
        assertThrows(EmptyTreeException.class, root::min);
        assertThrows(EmptyTreeException.class, () -> root.find(2));
        assertThrows(EmptyTreeException.class, () -> root.delete(2));

    }
    @Test
    public void minAndMaxTest() {
        assertEquals(5, root.min());
        assertEquals(90, root.max());
        root.insert(2);
        root.insert(99);
        assertEquals(2, root.min());
        assertEquals(99, root.max());
    }

    @Test
    public void findTest() {
        assertTrue(root.find(50));
        assertTrue(root.find(5));
        assertTrue(root.find(90));
        assertTrue(root.find(65));
        assertFalse(root.find(8));
        assertFalse(root.find(100));
        assertFalse(root.find(33));
        root.insert(33);
        root.insert(34);
        assertTrue(root.find(34));
        assertTrue(root.find(33));
    }

    @Test
    public void deleteTest() {
        assertFalse(root.delete(999));
        assertTrue(root.delete(5));
        assertFalse(root.find(5));
        assertTrue(root.delete(90));
        assertFalse(root.find(90));
        assertTrue(root.delete(65));
        assertFalse(root.find(65));
        var expected = "{10}{20}{25}{30}{40}{45}{50}{66}{67}{70}{80}";
        assertEquals(expected, root.toString());
        assertTrue(root.delete(70));
        assertFalse(root.find(70));
        expected = "{10}{20}{25}{30}{40}{45}{50}{66}{67}{80}";
        assertEquals(expected, root.toString());
        assertTrue(root.delete(67));
        assertTrue(root.delete(66));
        assertFalse(root.find(67));
        assertFalse(root.find(66));
        expected = "{10}{20}{25}{30}{40}{45}{50}{80}";
        assertEquals(expected, root.toString());
        root = new BinaryTree<>();
        root.insert(100);
        assertTrue(root.delete(100));
        assertThrows(EmptyTreeException.class, () -> root.find(100));
        assertEquals("{}", root.toString());
    }

}
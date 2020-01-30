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
        root.insert(10);
        root.insert(60);
        root.insert(70);
        root.insert(70);
        root.insert(71);
        root.insert(11);
        root.insert(9);
        root.insert(44);
        root.insert(55);
        root.insert(54);
        root.insert(56);
        root.insert(69);
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
        assertEquals(9, root.min());
        assertEquals(71, root.max());
        root.insert(8);
        root.insert(99);
        assertEquals(8, root.min());
        assertEquals(99, root.max());
    }

    @Test
    public void findTest() {
        assertTrue(root.find(50));
        assertTrue(root.find(9));
        assertTrue(root.find(71));
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
        assertTrue(root.delete(9));
        assertFalse(root.find(9));
        assertTrue(root.delete(71));
        assertFalse(root.find(71));
        assertTrue(root.delete(60));
        assertFalse(root.find(60));
        root = new BinaryTree<>(100);
        assertTrue(root.delete(100));
        assertThrows(EmptyTreeException.class, () -> root.find(2));
    }

}
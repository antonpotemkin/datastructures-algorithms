package ru.potemkin.dsa.adt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.potemkin.dsa.exception.EmptyException;
import ru.potemkin.dsa.exception.InsertException;
import ru.potemkin.dsa.exception.RemoveException;

class StackTest {
    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(5);
    }

    @Test
    void pushAndPop() {
        stack.push(4);
        stack.push(2);
        stack.push(6);
        stack.push(3);
        stack.push(9);
        Assertions.assertTrue(stack.isFull());
        Assertions.assertEquals(9, stack.pop());
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(6, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(4, stack.peek());
        Assertions.assertEquals(4, stack.pop());
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertThrows(RemoveException.class, () -> stack.pop());
        Assertions.assertThrows(EmptyException.class, () -> stack.peek());
    }

    @Test
    void popAssertException() {
        Assertions.assertThrows(RemoveException.class, () -> stack.pop());
        Assertions.assertThrows(EmptyException.class, () -> stack.peek());
        stack.push(4);
        stack.push(2);
        stack.push(6);
        stack.push(3);
        stack.push(9);
        Assertions.assertThrows(InsertException.class, () -> stack.push(1));
    }
}
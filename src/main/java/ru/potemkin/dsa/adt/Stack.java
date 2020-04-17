package ru.potemkin.dsa.adt;

import ru.potemkin.dsa.exception.InsertException;
import ru.potemkin.dsa.exception.RemoveException;

/**
 * Simple implementation of stack
 */
public class Stack {
    private int[] elements;
    private int size;

    public Stack(int size) {
        this.elements = new int[size];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public void push(int element) {
        if (isFull())
            throw new InsertException("Stack is full");
        elements[size++] = element;
    }

    public int pop() {
        if (isEmpty())
            throw new RemoveException("Stack is empty");
        return elements[--size];
    }
}

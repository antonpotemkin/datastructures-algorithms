package ru.potemkin.dsa.adt;

import ru.potemkin.dsa.exception.InsertException;
import ru.potemkin.dsa.exception.RemoveException;

public class PriorityQueue {
    private int[] elements;
    private int nElements;

    public PriorityQueue(int size) {
        this.elements = new int[size];
        this.nElements = 0;
    }

    public boolean isEmpty() {
        return nElements == 0;
    }

    public boolean isFull() {
        return elements.length == nElements;
    }

    public void inQueue(int element) {
        if (isFull()) {
            throw new InsertException("PriorityQueue is full");
        }
        var counter = nElements;
        while(counter > 0 && elements[counter - 1] < element) {
            elements[counter] = elements[counter - 1];
            counter --;
        }
        elements[counter] = element;
        nElements ++;
    }

    public int deQueue() {
        if (isEmpty()) {
            throw new RemoveException("Queue is empty");
        }
        return elements[--nElements];
    }
}

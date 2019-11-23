package ru.potemkin.dsa.adt;

import ru.potemkin.dsa.exception.InsertException;
import ru.potemkin.dsa.exception.RemoveException;

public class Queue {
    private int[] elements;
    private int nElements;
    private int front;
    private int rear;

    public Queue(int size) {
        this.elements = new int[size];
        this.nElements = 0;
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return nElements == 0;
    }

    public boolean isFull() {
        return nElements == elements.length;
    }

    public void inQueue(int element) {
        if (isFull()) {
            throw new InsertException("Queue is full");
        }
        if (rear == elements.length - 1) {
            rear = -1;
        }
        elements[++rear] = element;
        nElements++;
    }

    public int deQueue() {
        if (isEmpty()) {
            throw new RemoveException("Queue is empty");
        }
        var element = elements[++front];
        nElements--;
        if (front == elements.length - 1) {
            front = -1;
        }
        return element;
    }
}

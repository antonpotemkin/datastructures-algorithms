package ru.potemkin.dsa.pyramid;

import ru.potemkin.dsa.exception.RemoveException;
import ru.potemkin.dsa.model.DataItem;

/**
 * Implementation of Priority Queue using pyramid algorithm
 */
public class Pyramid {
    private final int maxSize;
    private final DataItem[] nodes;
    private int crtSize;

    public Pyramid(int crtSize) {
        this.nodes = new DataItem[crtSize];
        this.maxSize = crtSize;
        this.crtSize = 0;
    }

    public boolean insert(DataItem node) {
        if (crtSize == maxSize)
            return false;
        nodes[crtSize] = node;
        trickleUp(crtSize++);
        return true;
    }

    private void trickleUp(int index) {
        var parentIdx = (index - 1) / 2;
        var node = nodes[index];
        while (index > 0 && nodes[parentIdx].getKey() < node.getKey()) {
            nodes[index] = nodes[parentIdx];
            index = parentIdx;
            parentIdx = (parentIdx - 1) / 2;
        }
        nodes[index] = node;
    }

    private void trickleDown(int index) {
        int largerIdx;
        var node = nodes[index];
        while (index < crtSize / 2) {
            var leftIdx = index * 2 + 1;
            var rightIdx = leftIdx + 1;
            if (rightIdx < crtSize && nodes[leftIdx].getKey() < nodes[rightIdx].getKey())
                largerIdx = rightIdx;
            else
                largerIdx = leftIdx;
            if (node.getKey() < nodes[largerIdx].getKey()) {
                nodes[index] = nodes[largerIdx];
                index = largerIdx;
            } else
                break;
        }
        nodes[index] = node;
    }

    public DataItem remove() {
        if (crtSize == 0)
            throw new RemoveException("Pyramid is empty");
        var node = nodes[0];
        nodes[0] = nodes[--crtSize];
        trickleDown(0);
        return node;
    }

}

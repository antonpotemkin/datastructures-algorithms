package ru.potemkin.dsa.graph;

import ru.potemkin.dsa.adt.Queue;
import ru.potemkin.dsa.adt.Stack;


/**
 * Implementation of unweighted graph algorithm
 */
public class UnweightGraph extends AbstractGraph {
    private Stack stack;
    private Queue queue;

    public UnweightGraph(int maxSize) {
        super(maxSize);
        this.stack = new Stack(maxSize);
        this.queue = new Queue(maxSize);
    }

    public void addEdge(String from, String to) {
        int idxFrom = findIdx(from);
        int idxTo = findIdx(to);
        if (idxFrom == -1 || idxTo == -1)
            return;
        matrix[idxFrom][idxTo] = 1;
        matrix[idxTo][idxFrom] = 1;
    }

    public String dfs() {
        if (nVertx == 0)
            return "";
        var vertex = vertices[0];
        vertex.setVisited(true);
        stack.push(0);
        StringBuilder result = new StringBuilder(vertex.getLabel());
        while (!stack.isEmpty()) {
            int unvisitedVer = getUnvisitedVer(stack.peek());
            if (unvisitedVer == -1)
                stack.pop();
            else {
                vertex = vertices[unvisitedVer];
                vertex.setVisited(true);
                stack.push(unvisitedVer);
                result.append(vertex.getLabel());
            }
        }
        setUnvisited();
        return result.toString();
    }

    public String bfs() {
        if (nVertx == 0)
            return "";
        var vertex = vertices[0];
        vertex.setVisited(true);
        queue.inQueue(0);
        StringBuilder result = new StringBuilder(vertex.getLabel());
        while (!queue.isEmpty()) {
            int childIdx = -1;
            var parentIdx = queue.deQueue();
            while ((childIdx = getUnvisitedVer(parentIdx)) != -1) {
                vertex = vertices[childIdx];
                vertex.setVisited(true);
                queue.inQueue(childIdx);
                result.append(vertex.getLabel());
            }
        }
        setUnvisited();
        return result.toString();
    }
}

package ru.potemkin.dsa.graph;

import ru.potemkin.dsa.adt.Stack;
import ru.potemkin.dsa.exception.EmptyException;

import java.util.Optional;

/**
 * Implementation of graph algorithm
 */
public class Graph {
    private final int maxSize;
    private Stack stack;
    private Vertex[] vertices;
    private int[][] matrix;
    private int nVertx;

    public Graph(int maxSize) {
        this.maxSize = maxSize;
        this.vertices = new Vertex[maxSize];
        this.stack = new Stack(maxSize);
        this.nVertx = 0;
        this.matrix = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++)
            for (int j = 0; j < maxSize; j++)
                matrix[i][j] = 0;
    }

    public void addVertex(String label) {
        vertices[nVertx++] = new Vertex(label);
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

    public int getUnvisitedVer(int verIdx) {
        for (int j = 0; j < maxSize; j++) {
            if (matrix[verIdx][j] == 1 && !vertices[j].isVisited())
                return j;
        }
        return -1;
    }

    private int findIdx(String label) {
        for (int i = 0; i < nVertx; i++) {
            if (vertices[i].getLabel().equals(label))
                return i;
        }
        return -1;
    }

    private void setUnvisited(){
        for (int i = 0; i < nVertx; i++)
            vertices[i].setVisited(false);
    }
}

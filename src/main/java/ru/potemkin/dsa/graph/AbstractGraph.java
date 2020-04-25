package ru.potemkin.dsa.graph;

public abstract class AbstractGraph {
    protected final int maxSize;
    protected int nVertx;
    protected Vertex[] vertices;
    protected int[][] matrix;

    public AbstractGraph(int maxSize) {
        this.maxSize = maxSize;
        this.nVertx = 0;
        this.vertices = new Vertex[maxSize];
        this.matrix = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++)
            for (int j = 0; j < maxSize; j++)
                matrix[i][j] = -1;
    }

    public void addVertex(String label) {
        this.vertices[nVertx++] = new Vertex(label);
    }

    protected int getUnvisitedVer(int verIdx) {
        for (int j = 0; j < maxSize; j++) {
            if (matrix[verIdx][j] == 1 && !vertices[j].isVisited())
                return j;
        }
        return -1;
    }

    protected int findIdx(String label) {
        for (int i = 0; i < nVertx; i++) {
            if (vertices[i].getLabel().equals(label))
                return i;
        }
        return -1;
    }

    protected void setUnvisited() {
        for (int i = 0; i < nVertx; i++)
            vertices[i].setVisited(false);
    }
}

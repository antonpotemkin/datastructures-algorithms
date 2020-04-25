package ru.potemkin.dsa.graph;

/**
 * Implementation of weighted graph algorithm
 */
// TODO use priorityQueue for find min distance
public class WeightedGraph extends AbstractGraph {
    private DistancePath[] paths;

    public WeightedGraph(int maxSize) {
        super(maxSize);
        this.paths = new DistancePath[maxSize];
    }

    public void addEdge(String from, String to, int weight) {
        int idxFrom = findIdx(from);
        int idxTo = findIdx(to);
        if (idxFrom == -1 || idxTo == -1)
            return;
        matrix[idxFrom][idxTo] = weight;
    }

    /**
     * Implementation of Dijkstra Algorithm
     */
    public void path() {
        if (nVertx == 0)
            return;
        int startVertex = 0;
        vertices[startVertex].setVisited(true);
        int nTree = 1;
        //init paths
        for (int j = 0; j < nVertx; j++) {
            int dist = matrix[startVertex][j];
            paths[j] = new DistancePath(startVertex, dist);
        }
        int crtVer = 0;
        int crtWght = 0;
        while (nTree < nVertx) {
            crtVer = getMin();
            crtWght = paths[crtVer].getDistance();
            if (crtWght == -1)
                break;
            vertices[crtVer].setVisited(true);
            nTree++;
            updateWeight(crtVer, crtWght);
        }

        setUnvisited();
    }

    private void updateWeight(int crtVer, int crtWght) {
        int column = 1;
        while (column < nVertx) {
            if (vertices[column].isVisited()) {
                column++;
                continue;
            }
            int tmpWght = this.matrix[crtVer][column];
            if (tmpWght == -1) {
                column++;
                continue;
            }
            int newWght = tmpWght + crtWght;
            int wght = paths[column].getDistance();
            if (wght == -1 || newWght < wght) {
                paths[column] = new DistancePath(crtVer, newWght);
            }
            column++;
        }
    }

    private int getMin() {
        int index = 0;
        int min = paths[index].getDistance();
        for (int j = 1; j < nVertx; j++) {
            if (!vertices[j].isVisited() &&
                    paths[j].getDistance() != -1 &&
                    (paths[j].getDistance() < min || min == -1)) {
                min = paths[j].getDistance();
                index = j;
            }
        }
        return index;
    }


    public DistancePath[] getPaths() {
        return paths;
    }
}

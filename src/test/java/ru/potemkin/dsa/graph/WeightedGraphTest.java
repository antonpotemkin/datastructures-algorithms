package ru.potemkin.dsa.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.Stream;

public class WeightedGraphTest {
    private WeightedGraph graph = new WeightedGraph(20);

    @BeforeEach
    public void setUp() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "C", 50);
        graph.addEdge("B", "C", 20);
        graph.addEdge("B", "D", 30);
        graph.addEdge("C", "D", 40);
        graph.addEdge("D", "E", 5);
        graph.addEdge("C", "E", 20);
    }

    @Test
    public void emptyTest() {
        graph = new WeightedGraph(10);
        graph.path();
        for (DistancePath path: graph.getPaths())
            Assertions.assertNull(path);
    }

    @Test
    public void testPath() {
        graph.path();
        DistancePath[] paths = graph.getPaths();
        Assertions.assertEquals(
                4,Stream.of(paths).filter(Objects::nonNull).filter(path -> path.getDistance() != -1).count()
        );
        Assertions.assertEquals(0, paths[1].getParent());
        Assertions.assertEquals(10, paths[1].getDistance());
        Assertions.assertEquals(1, paths[2].getParent());
        Assertions.assertEquals(30, paths[2].getDistance());
        Assertions.assertEquals(1, paths[3].getParent());
        Assertions.assertEquals(40, paths[3].getDistance());
        Assertions.assertEquals(3, paths[4].getParent());
        Assertions.assertEquals(45, paths[4].getDistance());
    }
}
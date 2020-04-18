package ru.potemkin.dsa.graph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    private static Graph graph = new Graph(20);

    @BeforeAll
    public static void setUp() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "E");
    }

    @Test
    public void test_dfs(){
        String result = "ABEDC";
        assertEquals(result, graph.dfs());
        assertEquals(result, graph.dfs());
    }

    @Test
    public void test_empty() {
        graph = new Graph(10);
        assertEquals("", graph.dfs());
        graph.addEdge("A", "B");
        assertEquals("", graph.dfs());
    }
}
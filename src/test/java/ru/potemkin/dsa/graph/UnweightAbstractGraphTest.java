package ru.potemkin.dsa.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnweightAbstractGraphTest {
    private UnweightGraph graph = new UnweightGraph(20);

    @BeforeEach
    public void setUp() {
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
    public void test_bfs(){
        String result = "ABCDE";
        assertEquals(result, graph.bfs());
        assertEquals(result, graph.bfs());
    }

    @Test
    public void test_empty() {
        graph = new UnweightGraph(10);
        assertEquals("", graph.dfs());
        assertEquals("", graph.bfs());
        graph.addEdge("A", "B");
        assertEquals("", graph.dfs());
    }
}
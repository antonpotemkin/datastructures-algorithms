package ru.potemkin.dsa.graph;

import lombok.Data;

@Data
public class DistancePath {
    private final int parent;   // parent vertex
    private final int distance; // distance from start Vertex
}

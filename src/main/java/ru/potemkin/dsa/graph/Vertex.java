package ru.potemkin.dsa.graph;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Vertex {
    private final String label;
    private boolean visited;

    public Vertex(String label) {
        this.label = label;
        this.visited = false;
    }
}

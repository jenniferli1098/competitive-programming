package graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetection {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v5 = new Vertex("5");
        Vertex v4 = new Vertex("4");
        Vertex v8 = new Vertex("8");
        Vertex v9 = new Vertex("9");

        v1.addNeighbour(v2);
        v2.addNeighbour(v4);
        v4.addNeighbour(v8);
        v4.addNeighbour(v9);
        v2.addNeighbour(v5);
        v5.addNeighbour(v1);

        dfs(v1);
        dfs(v2);
        dfs(v5);
        dfs(v4);
        dfs(v8);
        dfs(v9);
    }

    public static void dfs(Vertex start) {
        if (start.visisted) return;
        start.beingVisited = true;

        for(Vertex v : start.neighbours) {
            if(v.beingVisited) {
                System.out.println("Cycle found!");
                return;
            } else {
                dfs(v);
            }
        }

        start.visisted = true;
        start.beingVisited = false;
    }

    static class Vertex {
        String name;
        boolean visisted;
        boolean beingVisited;
        List<Vertex> neighbours;

        public Vertex(String name) {
            this.name = name;
            this.visisted = false;
            this.beingVisited = false;
            this.neighbours = new ArrayList<>();
        }

        public void addNeighbour(Vertex vertex) {
            this.neighbours.add(vertex);
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}

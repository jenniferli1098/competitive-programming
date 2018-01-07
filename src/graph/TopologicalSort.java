package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    static Stack<Vertex> stack;

    public static void main(String[] args) {
        stack = new Stack<>();

        List<Vertex> graph = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            graph.add(new Vertex("" + i));
        }

        graph.get(2).addNeighbour(graph.get(3));
        graph.get(3).addNeighbour(graph.get(1));
        graph.get(4).addNeighbour(graph.get(0));
        graph.get(4).addNeighbour(graph.get(1));
        graph.get(5).addNeighbour(graph.get(0));
        graph.get(5).addNeighbour(graph.get(2));

        for (Vertex v : graph) {
            if (!v.visited) {
                topologicalSort(v);
            }
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }

    public static void topologicalSort(Vertex start) {
        if (start.visited) {
            return;
        }

        start.visited = true;

        for (Vertex v : start.neighbours) {
            topologicalSort(v);
        }

        stack.push(start);
    }

    public static class Vertex {
        String data;
        boolean visited;
        List<Vertex> neighbours;

        public Vertex(String data) {
            this.data = data;
            this.visited = false;
            this.neighbours = new ArrayList<>();
        }

        public void addNeighbour(Vertex v) {
            this.neighbours.add(v);
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "data='" + data + '\'' +
                    ", visited=" + visited +
                    '}';
        }
    }
}

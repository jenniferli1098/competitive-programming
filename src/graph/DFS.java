package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        Vertex[] vertices = new Vertex[6];

        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex("" + i);
        }

        vertices[0].addNeighbour(vertices[1]);
        vertices[0].addNeighbour(vertices[2]);
        vertices[1].addNeighbour(vertices[3]);
        vertices[1].addNeighbour(vertices[4]);
        vertices[4].addNeighbour(vertices[5]);

        dfsDriverMethod(new ArrayList<>(Arrays.asList(vertices)));
    }

    static void dfsDriverMethod(ArrayList<Vertex> vertexList) {
        // multiple clusters of graph
        for (Vertex v : vertexList) {
            if (!v.visited) {
                v.visited = true;
                dfsStack(v);
            }
        }
    }

    static void dfsStack(Vertex root) {
        Stack<Vertex> stack = new Stack<>();
        stack.add(root);
        root.visited = true;

        while (!stack.isEmpty()) {
            Vertex actualVertex = stack.pop();

            System.out.println(actualVertex);

            for (Vertex v : actualVertex.neighbours) {
                if (!v.visited) {
                    v.visited = true;
                    stack.push(v);
                }
            }
        }
    }

    static void dfsRecursive(Vertex actualVertex) {
        System.out.println(actualVertex);

        actualVertex.visited = true;

        for (Vertex v : actualVertex.neighbours) {
            if (!v.visited) {
                v.visited = true;
                dfsRecursive(v);
            }
        }
    }

    static class Vertex {
        String name;
        boolean visited;
        ArrayList<Vertex> neighbours;

        public Vertex(String name) {
            this.name = name;
            this.visited = false;
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
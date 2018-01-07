package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        Vertex[] vertices = new Vertex[6];

        for(int i = 0; i < 6; i++) vertices[i] = new Vertex(i);

        vertices[0].addNeighbour(vertices[1]);
        vertices[1].addNeighbour(vertices[2]);
        vertices[1].addNeighbour(vertices[4]);
        vertices[4].addNeighbour(vertices[5]);
        vertices[5].addNeighbour(vertices[5]);

        bfs(vertices[0]);

    }

    static void bfs(Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(start);
        start.visited = true;

        while(!queue.isEmpty()) {
            Vertex curr = queue.remove();

            for(Vertex v : curr.neighbourList) {
                if(!v.visited) {
                    v.visited = true;
                    queue.add(v);
                }
            }
        }
    }

    static class Vertex {
        int data;
        boolean visited;
        ArrayList<Vertex> neighbourList;

        public Vertex(int data) {
            this.data = data;
            this.visited = false;
            this.neighbourList = new ArrayList<>();
        }

        public void addNeighbour(Vertex v) {
            this.neighbourList.add(v);
        }

        @Override
        public String toString() {
            return "" + this.data;
        }
    }
}
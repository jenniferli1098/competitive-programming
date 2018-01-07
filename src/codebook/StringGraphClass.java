package codebook;

import java.util.*;

public class StringGraphClass {
    static Graph g = new Graph();

    public static void main(String[] args) {

    }

    static void dfs(String u) { // Call resetVisited() before starting recursive method
        if (g.isMarked(u)) {
            return;
        }

        g.markVisited(u);

        TreeSet<String> current = g.getSubset(u);

        for (String x : current) {
            dfs(x);
        }
    }

    static void bfs(String u) {
        g.resetVisited();

        Queue<String> queue = new ArrayDeque<>();
        queue.add(u);
        g.markVisited(u);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            TreeSet<String> toVisit = g.getSubset(current);
            for (String x : toVisit) {
                if (!g.isMarked(x)) {
                    queue.add(x);
                }
            }
        }
    }

    static class Graph {
        static TreeMap<String, TreeSet<String>> graph;
        static HashSet<String> visited;

        public Graph() {
            this.graph = new TreeMap<>();
        }

        public TreeSet<String> getSubset(String identifier) {
            if (!this.graph.containsKey(identifier)) {
                createVertex(identifier);
            }

            return this.graph.get(identifier);
        }

        public void createVertex(String x) {
            this.graph.put(x, new TreeSet<>());
        }

        public void addDirectedEdge(String start, String end) {
            verifyParameters(start, end);
            this.graph.get(start).add(end);
        }

        public void addUndirectedEdge(String start, String end) {
            verifyParameters(start, end);
            this.graph.get(start).add(end);
            this.graph.get(end).add(start);
        }

        public void verifyParameters(String a, String b) {
            if (!this.graph.containsKey(a)) {
                createVertex(a);
            }

            if (!this.graph.containsKey(b)) {
                createVertex(b);
            }
        }

        public boolean nodeExists(String identifier) {
            return this.graph.containsKey(identifier);
        }

        public void resetVisited() {
            this.visited = new HashSet<>();
        }

        public void markVisited(String identifier) {
            this.visited.add(identifier);
        }

        public boolean isMarked(String identifier) {
            if (this.graph.containsKey(identifier)) {
                return this.visited.contains(identifier);
            }

            throw new NoSuchElementException();
        }

        public void debug() {
            System.out.println(this.graph.toString());
        }

    }
}
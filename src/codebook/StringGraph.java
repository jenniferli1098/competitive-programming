package codebook;

import java.util.*;

public class StringGraph {
    static TreeMap<String, TreeSet<String>> graph;
    static HashSet<String> visited;

    public static void main(String[] args) {
        graph = new TreeMap<>();
        visited = new HashSet<>();

        // out.close();
    }

    static void dfs(String u) { // Call resetVisited() before starting recursive method
        if (visited.contains(u)) {
            return;
        }

        visited.add(u);

        TreeSet<String> current = getSubset(u);

        for (String x : current) {
            dfs(x);
        }
    }

    static void bfs(String u) {
        resetVisited();

        Queue<String> queue = new ArrayDeque<>();
        queue.add(u);
        visited.add(u);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            TreeSet<String> toVisit = getSubset(current);
            for (String x : toVisit) {
                if (!visited.contains(x)) {
                    queue.add(x);
                }
            }
        }
    }

    static TreeSet<String> getSubset(String identifier) {
        if (!graph.containsKey(identifier)) {
            createVertex(identifier);
        }

        return graph.get(identifier);
    }

    static void createVertex(String x) {
        graph.put(x, new TreeSet<>());
    }

    static void addDirectedEdge(String start, String end) {
        verifyParameters(start, end);
        graph.get(start).add(end);
    }

    static void addUndirectedEdge(String start, String end) {
        verifyParameters(start, end);
        graph.get(start).add(end);
        graph.get(end).add(start);
    }

    static void verifyParameters(String a, String b) {
        if (!graph.containsKey(a)) {
            createVertex(a);
        }

        if (!graph.containsKey(b)) {
            createVertex(b);
        }
    }

    static boolean nodeExists(String identifier) {
        return graph.containsKey(identifier);
    }

    static void resetVisited() {
        visited = new HashSet<>();
    }

    static void debug() {
        System.out.println(graph.toString());
    }

}

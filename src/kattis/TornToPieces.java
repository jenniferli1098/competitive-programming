package kattis;

import codebook.FastScanner;

import java.io.PrintWriter;
import java.util.*;

public class TornToPieces {

    static TreeMap<String, List<String>> graph;
    static HashSet<String> visited;
    static String destination;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.nextInt();
        graph = new TreeMap<>();
        visited = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String[] tokens = in.nextLine().split(" ");

            if (!graph.containsKey(tokens[0])) {
                graph.put(tokens[0], new ArrayList<>());
            }

            for (int j = 1; j < tokens.length; j++) {
                if (!graph.containsKey(tokens[j])) {
                    graph.put(tokens[j], new ArrayList<>());
                }

                graph.get(tokens[0]).add(tokens[j]);
                graph.get(tokens[j]).add(tokens[0]);
            }
        }

        String start = in.next();
        destination = in.next();

        bfs(start, out);
    }

    public static void bfs(String start, PrintWriter out) {
        Queue<String> queue = new LinkedList<>();
        HashMap<String, String> nodetoHead = new HashMap<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            String curr = queue.remove();
            visited.add(curr);

            if(!graph.containsKey(curr)) {
                graph.put(curr, new ArrayList<>());
            }

            for (String v : graph.get(curr)) {
                if (!visited.contains(v)) {
                    nodetoHead.put(v, curr);
                    queue.add(v);
                }
            }
        }

        if (!visited.contains(destination)) {
            out.println("no route found");
        } else {
            Stack<String> print = new Stack<>();

            nodetoHead.put(start, null);

            String curr = nodetoHead.get(destination);
            print.add(destination);

            while (curr != null) {
                print.push(curr);
                curr = nodetoHead.get(curr);
            }

            int sz = print.size();
            for (int i = 0; i < sz; i++) {
                out.print(print.pop() + " ");
            }
        }
    }
}

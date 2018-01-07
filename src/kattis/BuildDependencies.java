package kattis;

import codebook.FastScanner;

import java.io.PrintWriter;
import java.util.*;

public class BuildDependencies {

    static TreeMap<String, ArrayList<String>> graph;
    static HashSet<String> visited;
    static Stack<String> stack;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.nextInt();

        graph = new TreeMap<>();
        visited = new HashSet<>();
        stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String[] tokens = in.nextLine().split(" ");

            String baseName = tokens[0].substring(0, tokens[0].length() - 1);

            if(!graph.containsKey(baseName)) {
                graph.put(baseName, new ArrayList<>());
            }

            for(int j = 1; j < tokens.length; j++) {
                String curr = tokens[j];

                if(!graph.containsKey(curr)) {
                    graph.put(curr, new ArrayList<>());
                }

                graph.get(curr).add(baseName);
            }
        }

        String end = in.next();
        topologicalSort(end);

        int size = stack.size();

        for(int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }

    public static void topologicalSort(String start) {
        if(visited.contains(start)) {
           return;
        }

        visited.add(start);

        for(String neighbour : graph.get(start)) {
            topologicalSort(neighbour);
        }

        stack.add(start);
    }
}
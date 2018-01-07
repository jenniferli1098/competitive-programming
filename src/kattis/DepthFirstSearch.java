package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class DepthFirstSearch {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static TreeMap<Character, TreeSet<Character>> adj = new TreeMap<>();
    static HashSet<Character> marked = new HashSet<>();

    public static void main(String[] args) {
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            adj.put(sc.next().charAt(0), new TreeSet<>());
        }

        for (int i = 0; i < N; i++) {
            String[] tokens = sc.nextLine().split(" ");
            char target = tokens[0].charAt(0);

            for (int j = 2; j < tokens.length; j++) {
                adj.get(target).add(tokens[j].charAt(0));
            }
        }

        for (Map.Entry<Character, TreeSet<Character>> entry : adj.entrySet()) {
            dfs(entry.getKey());
        }

        out.close();
    }

    static void dfs(char u) {
        if (marked.contains(u)) {
            return;
        }

        System.out.println(u);
        marked.add(u);

        TreeSet<Character> target = adj.get(u);

        for (char x : target) {
            dfs(x);
        }

    }

    static void dfs(String u) {

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        char nextChar() {
            return nextLine().charAt(0);
        }
    }
}
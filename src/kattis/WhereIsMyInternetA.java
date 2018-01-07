package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class WhereIsMyInternetA {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static HashSet<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            graph.add(i, new ArrayList<>());
        }

        int R = sc.nextInt();

        for (int i = 0; i < R; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(0);

        if (visited.size() == N) {
            out.println("Connected");
        } else {
            for (int i = 0; i < N; i++) {
                if (!visited.contains(i)) {
                    out.println(i + 1);
                }
            }
        }

        out.close();
    }

    static void dfs(int u) {
        if (visited.contains(u)) {
            return;
        }

        visited.add(u);

        ArrayList<Integer> target = graph.get(u);

        for (int i : target) {
            dfs(i);
        }
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
            return next().charAt(0);
        }
    }
}
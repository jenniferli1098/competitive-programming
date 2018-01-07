package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WhereIsMyInternetB {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int N = sc.nextInt();
        Union union = new Union(N);

        int R = sc.nextInt();

        for (int i = 0; i < R; i++) {
            union.unite(sc.nextInt() - 1, sc.nextInt() - 1);
        }

        boolean[] connectedToRoot = new boolean[N];
        int connectedCount = 1;

        for (int i = 1; i < N; i++) {
            connectedToRoot[i] = union.connected(0, i);

            if (connectedToRoot[i]) {
                ++connectedCount;
            }
        }

        if (connectedCount == N) {
            out.println("Connected");
        } else {
            for (int i = 1; i < N; i++) {
                if (!connectedToRoot[i]) {
                    out.println(i + 1);
                }
            }
        }

        out.close();
    }


    public static class Union {
        int[] parent;

        public Union(int N) {
            this.parent = new int[N];

            for (int i = 0; i < this.parent.length; i++) {
                this.parent[i] = i;
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public int find(int x) {
            if (this.parent[x] == x) {
                return x;
            } else {
                this.parent[x] = find(this.parent[x]);
                return this.parent[x];
            }
        }

        public void unite(int x, int y) {
            this.parent[find(x)] = find(y);
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
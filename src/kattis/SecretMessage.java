package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SecretMessage {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int testCase = sc.nextInt();

        for (int testCount = 0; testCount < testCase; testCount++) {
            String message = sc.next();

            int L = message.length();

            int M = (int) Math.ceil(Math.sqrt(L));

            // Build the two-dimensional character array
            char[][] grid = buildGrid(M, new StringBuilder(message));

            /* DEBUG
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < M; j++) {
                    out.print(grid[i][j] + " ");
                }

                out.println();
            }
            */

            // Reverse lookup the grid and print as traversing occurs
            for (int i = 0; i < M; i++) {
                for (int j = M - 1; j >= 0; j--) {
                    if (grid[j][i] != '*') {
                        out.print(grid[j][i]);
                    }
                }
            }

            out.println();
        }

        out.close();
    }

    public static char[][] buildGrid(int sz, StringBuilder message) {
        // Fill in asterisks
        for (int i = 0; i < sz * sz - message.length(); i++) {
            message.append('*');
        }

        char[][] grid = new char[sz][sz];

        // Populate the grid
        int x = 0;
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                grid[i][j] = message.charAt(x++);
            }
        }

        return grid;
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
package kattis;

import java.io.*;
import java.util.StringTokenizer;

public class ClosestSums {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        String in = sc.nextLine();
        int tests = 1;

        while (in != null && in.length() != 0) {
            int N = Integer.parseInt(in);

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            out.println("Case " + tests + ":");

            int Q = sc.nextInt();

            for (int i = 0; i < Q; i++) {
                int Qi = sc.nextInt();
                int ans = arr[0] + arr[1];

                for (int x = 0; x < N; x++) {
                    for (int y = x + 1; y < N; y++) {
                        int sum = arr[x] + arr[y];

                        if (Math.abs(sum - Qi) < Math.abs(Qi - ans)) {
                            ans = sum;
                        }
                    }
                }

                out.println("Closest sum to " + Qi + " is " + ans + ".");
            }

            ++tests;
            in = sc.nextLine();
        }

        out.close();
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
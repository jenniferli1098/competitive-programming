package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCC_14_S1 {
    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int K = sc.nextInt();
        int m = sc.nextInt();

        int[] values = new int[K];
        for(int i = 0; i < K; i++)
            values[i] = i;

        for(int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int index = 0;

            for(int j = 0; j < K; j++) {
                if(values[j] == Integer.MIN_VALUE)
                    continue;
                if ((index + 1) % r == 0)
                    values[j] = Integer.MIN_VALUE;
                ++index;
            }
        }

        for(int i = 0; i < K; i++)
            if(values[i] != Integer.MIN_VALUE)
                out.println(i + 1);
        out.close();
    }

    public static class FastScanner {
        static BufferedReader br;
        static StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        static String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
            return st.nextToken();
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static char nextChar() throws IOException {
            return next().charAt(0);
        }

        static String nextLine() throws IOException {
            return br.readLine();
        }
    }
}

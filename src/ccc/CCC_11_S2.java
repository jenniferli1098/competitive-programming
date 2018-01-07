package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCC_11_S2 {
    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = sc.nextInt();

        char[] students = new char[N];
        char[] answers = new char[N];
        int correct = 0;

        for(int i = 0; i < N; i++)
            students[i] = sc.nextChar();

        for(int i = 0; i < N; i++)
            answers[i] = sc.nextChar();

        for(int i = 0; i < N; i++)
            if(students[i] == answers[i])
                ++correct;

        System.out.println(correct);
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
package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCC_03_J1 {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static StringBuilder print = new StringBuilder("");

    public static void main(String[] args) throws IOException {
        int tines = sc.nextInt();
        int spacing = sc.nextInt();
        int handle = sc.nextInt();

        for(int i = 0; i < tines; i++)
            printTine(tines, spacing);

        int space = 3 + spacing * (3 - 1);
        for(int i = 0; i < space; i++)
            print.append("*");
        print.append("\n");

        for(int j = 0; j < handle; j++) {
            for (int i = 0; i < space / 2; i++)
                print.append(" ");
            print.append("*\n");
        }


        out.println(print.toString());
        out.close();
    }

    public static void printTine(int x, int offset) {
        for(int i = 0; i < 3; i++) {
            print.append("*");
            for(int j = 0; j < offset; j++)
                print.append(" ");
        }

        print.append("\n");
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
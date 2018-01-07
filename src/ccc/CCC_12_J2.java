package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CCC_12_J2 {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] readings = new int[4];

        for(int i = 0; i < 4; i++)
            readings[i] = sc.nextInt();

        boolean same = true;
        for(int i = 1; i < 4; i++)
            if(readings[i] != readings[0])
                same = false;

        if(same)
            out.println("Fish At Constant Depth");
        else {
            boolean increasedSort = true;

            for(int i = 1; i < 4; i++)
                if(readings[i] < readings[i - 1])
                    increasedSort = false;

            if(increasedSort)
                out.println("Fish Rising");
            else {
                boolean decreaseSort = true;

                for(int i = 1; i < 4; i++)
                    if(readings[i] > readings[i - 1])
                        decreaseSort = false;

                if(decreaseSort)
                    out.println("Fish Diving");
                else
                    out.println("No Fish");
            }
        }

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
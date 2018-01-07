package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCC_04_J2 {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int start = sc.nextInt();
        int end = sc.nextInt();

        int index = 0;
        boolean programmer = true;
        boolean mayor = true;
        boolean dogcarcher = true;

        for(int i = start; i <= end; i++) {
            programmer = false;
            mayor = false;
            dogcarcher = false;
            if(index % 3 == 0)
                programmer = true;
            if(index % 4 == 0)
                mayor = true;
            if(index % 5 == 0)
                dogcarcher = true;

            if (programmer && mayor && dogcarcher)
                out.println("All positions change in year " + i);

            index++;
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
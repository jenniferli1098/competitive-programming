package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCC_14_J2 {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = sc.nextInt();
        int A = 0;
        int B = 0;
        char[] votes = sc.nextLine().toCharArray();

        for(int i = 0; i < N; i++)
            if(votes[i] == 'A')
                A++;
            else
                B++;

        if(A > B)
            out.println("A");
        else if(B > A)
            out.println("B");
        else
            out.println("Tie");

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
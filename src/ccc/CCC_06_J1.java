package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCC_06_J1 {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int total = 0;

        int[] choices = new int[4];
        for(int i = 0; i < choices.length; i++)
            choices[i] = sc.nextInt();

        if(choices[0] == 1)
            total += 461;
        else if(choices[0] == 2)
            total += 431;
        else if(choices[0] == 3)
            total += 420;

        if(choices[1] == 1)
            total += 100;
        else if(choices[1] == 2)
            total += 57;
        else if(choices[1] == 3)
            total += 70;

        if(choices[2] == 1)
            total += 130;
        else if(choices[2] == 2)
            total += 160;
        else if(choices[2] == 3)
            total += 118;

        if(choices[3] == 1)
            total += 167;
        else if(choices[3] == 2)
            total += 266;
        else if(choices[3] == 3)
            total += 75;

        out.printf("Your total Calorie count is %d.", total);

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
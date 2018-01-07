package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCC_05_J1 {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int dayTime = sc.nextInt();
        int evening = sc.nextInt();
        int weekend = sc.nextInt();

        int planA = 0;
        int planB = 0;

        if(dayTime > 100)
            planA += (dayTime - 100) * 25;
        planA += evening * 15;
        planA += weekend * 20;

        if(dayTime > 250)
            planB += (dayTime - 250) * 45;
        planB += evening * 35;
        planB += weekend * 25;

        out.printf("Plan A costs %.2f%nPlan B costs %.2f%n", planA / 100.0, planB / 100.0);

        if(planA == planB)
            out.println("Plan A and B are the same price.");
        else
            out.printf("Plan %s is cheapest.", (planA > planB ? "B" : "A"));

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
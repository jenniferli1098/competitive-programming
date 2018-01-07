package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CCC_02_S2 {
    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int numerator = sc.nextInt();
        int denomerator = sc.nextInt();

        if(numerator % denomerator == 0)
            out.println(numerator / denomerator);
        else {
            int whole = numerator / denomerator;
            int fractionNumerator = numerator % denomerator;
            int fractionDenomerator = denomerator;
            int gcf = gcf(fractionNumerator, fractionDenomerator);
            fractionNumerator /= gcf;
            fractionDenomerator /= gcf;
            out.println((whole > 0 ? whole + " " : "") + fractionNumerator + "/" + fractionDenomerator);
        }

        out.close();
    }

    public static int gcf(int x, int y) {
        TreeSet<Integer> values = new TreeSet<>();
        int highest = 1;

        for(int i = 1; i <= x; i++)
            if(x % i == 0)
                values.add(i);

        for(int i = 1; i <= y; i++)
            if(y % i == 0)
                if(values.contains(i))
                    highest = i;

        return highest;
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
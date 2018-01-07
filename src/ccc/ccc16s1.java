package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ccc16s1 {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        char[] firstInput = sc.nextLine().toCharArray();
        int[] firstTracker = new int['z' + 1];

        for (char i : firstInput) {
            firstTracker[i]++;
        }

        char[] secondInput = sc.nextLine().toCharArray();
        int[] secondTracker = new int['z' + 1];
        int asterisks = 0;

        for (char i : secondInput) {
            if(i == '*') ++asterisks;
            else secondTracker[i]++;
        }

        int upper = Math.min(firstTracker.length, secondTracker.length);

        for(int i = 0; i < upper; i++) {
            int diff = Math.abs(secondTracker[i] - firstTracker[i]);

            if(diff != 0) {
                asterisks -= diff;
            }

            if(asterisks < 0) {
                out.println("N");
                out.close();
            }
        }

        out.println("A");
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
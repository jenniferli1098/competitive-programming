package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CollatzConjecture {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {

        long a = sc.nextLong();
        long initialA = a;
        long b = sc.nextLong();
        long initialB = b;

        while (initialA != 0 && initialB != 0) {
            TreeMap<Long, Integer> stateToIndex = new TreeMap<>();

            int aIndex = 0;
            stateToIndex.put(a, aIndex);

            while (a != 1) {
                ++aIndex;

                if (a % 2 == 0) {
                    a /= 2;
                } else {
                    a = 3 * a + 1;
                }

                stateToIndex.put(a, aIndex);
            }

            if (initialA == 1) {
                stateToIndex.put((long) 1, 0);
            }

            int bIndex = 0;

            while (true) {
                if (stateToIndex.containsKey(b)) {
                    out.println(initialA + " needs " + stateToIndex.get(b) + " steps, " + initialB + " needs " + bIndex + " steps, they meet at " + b);
                    break;
                }

                ++bIndex;

                if (b % 2 == 0) {
                    b /= 2;
                } else {
                    b = 3 * b + 1;
                }
            }

            a = sc.nextLong();
            initialA = a;
            b = sc.nextLong();
            initialB = b;
        }

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
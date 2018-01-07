package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DiceCup {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int diceFace1 = sc.nextInt();
        int diceFace2 = sc.nextInt();

        int[] roll = new int[diceFace1 + diceFace2 + 1];
        int maxRoll = Integer.MIN_VALUE;

        for (int i = 1; i <= diceFace1; i++) {
            for (int j = 1; j <= diceFace2; j++) {
                roll[i + j] += 1;

                if (roll[i + j] > maxRoll) {
                    maxRoll = roll[i + j];
                }
            }
        }

        for (int i = 0; i < diceFace1 + diceFace2 + 1; i++) {
            if (roll[i] == maxRoll) {
                out.println(i);
            }
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
            return nextLine().charAt(0);
        }
    }
}
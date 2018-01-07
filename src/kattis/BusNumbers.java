package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BusNumbers {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int N = sc.nextInt();
        int[] busNumbers = new int[N + 1];
        busNumbers[N] = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            busNumbers[i] = sc.nextInt();
        }

        Arrays.sort(busNumbers);

        int currentBlockChain = 1;

        for (int i = 1; i <= N; i++) {
            if (busNumbers[i] == busNumbers[i - 1] + 1) {
                ++currentBlockChain;
            } else {
                if (currentBlockChain > 2) {
                    out.print(busNumbers[i - currentBlockChain] + "-" + busNumbers[i - 1] + " ");
                } else if (currentBlockChain > 1) {
                    out.print(busNumbers[i - 2] + " " + busNumbers[i - 1] + " ");
                } else {
                    out.print(busNumbers[i - 1] + " ");
                }

                currentBlockChain = 1;
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
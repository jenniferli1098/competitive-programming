package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc16j5s2 {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int Q = sc.nextInt();

        int N = sc.nextInt();
        int[] first = new int[N];
        int[] second = new int[N];
        int sum = 0;

        for(int i = 0; i < N; i++) {
            first[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++) {
            second[i] = sc.nextInt();
        }

        Arrays.sort(first);
        Arrays.sort(second);

        if(Q == 1) {
            for(int i = 0; i < N; i++) {
                sum += Math.max(first[i], second[i]);
            }
        } else {
            for(int i = 0; i < N; i++) {
                sum += Math.max(first[i], second[N - i - 1]);
            }
        }

        out.println(sum);

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
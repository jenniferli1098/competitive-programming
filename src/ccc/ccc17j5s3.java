package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ccc17j5s3 {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int N = sc.nextInt();

        int[] lengths = new int[2001];

        for(int i = 0; i < N; i++) {
            lengths[sc.nextInt()]++;
        }

        int maxLength = 1;
        int maxCnt = 0;

        for(int targetHeight = 0; targetHeight <= 4000; targetHeight++) {
            int length = 0;

            for(int i = 0; i < 2001; i++) {
                if(i > targetHeight || targetHeight - i > 2000 || lengths[targetHeight - i] == 0 || lengths[i] == 0) {
                    continue;
                }

                length += Math.min(lengths[i], lengths[targetHeight - i]);
            }

            if(maxLength < length) {
                maxLength = length;
                maxCnt = 1;
            } else if(maxLength == length) {
                ++maxCnt;
            }
        }

        out.println(maxLength / 2 + " " + maxCnt);

        out.close();
    }

    private static class FastScanner {
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
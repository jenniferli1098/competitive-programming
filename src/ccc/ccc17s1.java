package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc17s1 {
    static FastScanner sc = new FastScanner();

    public static void main(String[] args) {
        int N = sc.nextInt();
        int[] first = new int[N];
        int[] second = new int[N];

        for(int i = 0; i < N; i++) {
            first[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++) {
            second[i] = sc.nextInt();
        }

        int firstCnt = 0;
        int secondCnt = 0;
        int maxDay = 0;

        for(int i = 0; i < N; i++) {
            firstCnt += first[i];
            secondCnt += second[i];

            if(firstCnt == secondCnt) {
                maxDay = i + 1;
            }
        }

        System.out.println(maxDay);
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

package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc17j4 {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        long D = sc.nextLong();
        int hh = 12;
        int mm = 0;
        long totalCnt = 0;

        long factor = D / 1440;

        if (factor > 0) {
            totalCnt += 62 * factor;
            D %= 1440;
        }

        for (int i = 0; i < D; i++) {
            ++mm;

            if (hh == 12 && mm == 60) {
                hh = 1;
                mm = 0;
            }

            if (mm > 59) {
                mm = 0;
                ++hh;
            }

            if (isSequence(mm, hh)) {
                ++totalCnt;
            }
        }

        out.println(totalCnt);

        out.close();
    }

    public static boolean isSequence(int mins, int hours) {
        int[] time = new int[4];

        int startIndex = 0;

        if (hours > 9) {
            time[0] = 1;
            time[1] = hours % 10;
        } else {
            startIndex = 1;
            time[1] = hours;
        }

        if (mins > 9) {
            time[2] = mins / 10;
            time[3] = mins % 10;
        } else {
            time[2] = 0;
            time[3] = mins;
        }

        for (int i = -4; i < 5; i++) {
            int cnt = 0;

            for (int j = startIndex; j < time.length - 1; j++) {
                if (time[j] + i == time[j + 1]) {
                    ++cnt;
                }
            }

            if (cnt == time.length - 1 - startIndex) {
                return true;
            }
        }

        return false;
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
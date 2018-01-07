package kattis;

import codebook.FastScanner;

import java.io.PrintWriter;

public class GrowlingGears {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int testCases = in.nextInt();

        for (int testCasesCnt = 0; testCasesCnt < testCases; testCasesCnt++) {
            int N = in.nextInt();
            double totalMax = -1.0;
            int maxIndex = 1;

            for (int i = 0; i < N; i++) {
                double A = in.nextInt() * -1.0;
                double B = in.nextInt() * 1.0;
                double C = in.nextInt() * 1.0;

                double max = (-Math.pow(B, 2) + 4 * A * C) / (4 * A);

                if(max > totalMax) {
                    totalMax = max;
                    maxIndex = i + 1;
                }
            }

            out.println(maxIndex);
        }
    }
}

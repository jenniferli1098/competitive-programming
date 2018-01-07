package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FlexibleSpaces {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int W = sc.nextInt(); // width of room
        int partitionNumber = sc.nextInt(); // number of partitions

        int[] partitions = new int[partitionNumber]; // position of partition array
        boolean[] possibleWidths = new boolean[W + 1]; // all possible widths 1 to W inclusive

        // full room always possible
        possibleWidths[W] = true;

        // get partition indices
        for (int i = 0; i < partitionNumber; i++) {
            partitions[i] = sc.nextInt();

            // form from left and right side of room
            possibleWidths[partitions[i]] = true; // can form from 1 to partition index
            possibleWidths[W - partitions[i]] = true; // can form from W to partition index
        }

        // include space in between partition indices, eg. if partitions are 1, 5, 100,
        // possible room spaces are 100 - 5 = 95, 100 - 1 = 99, 5 - 1 = 4.
        for (int i = partitions.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                possibleWidths[partitions[i] - partitions[j]] = true;
            }
        }

        // print all flagged indices in boolean tracker array
        for (int i = 1; i <= W; i++) {
            if (possibleWidths[i]) {
                out.print(i + " ");
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
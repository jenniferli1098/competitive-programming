package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class DeduplicatingFiles {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int N = sc.nextInt();

        do {
            String[] fileNames = new String[N];
            int[] commonHashes = new int[N];
            TreeSet<String> uniqueFiles = new TreeSet<>();

            for (int i = 0; i < N; i++) {
                fileNames[i] = sc.nextLine();
                commonHashes[i] = commonHash(fileNames[i].toCharArray());
                uniqueFiles.add(fileNames[i]);
            }

            int duplicates = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (fileNames[i].equals(fileNames[j])) ;
                    else if (commonHashes[i] == commonHashes[j]) ++duplicates;
                }
            }

            out.println(uniqueFiles.size() + " " + duplicates);

            N = sc.nextInt();
        } while (N != 0);

        out.close();
    }

    public static int commonHash(char[] input) {
        int x = 0;

        for (int i = 0; i < input.length; i++) {
            x ^= input[i]; // THIS IS XOR WOW.
        }

        return x;
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
package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCC_03_S2 {
    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = sc.nextInt();
        String[] vowels = {"a", "e", "i", "o", "u"};

        for(int testCase = 0; testCase < N; testCase++) {
            String[] lastSyllable = new String[4];

            for(int i = 0; i < 4; i++) {
                String[] words = sc.nextLine().split(" ");
                String finalWord = words[words.length - 1].toLowerCase();

                int index = 0;

                for(int j = 0; j < 5; j++) {
                    int vowelIndex = finalWord.lastIndexOf(vowels[j]);

                    if(vowelIndex > index)
                        index = vowelIndex;
                }

                lastSyllable[i] = finalWord.substring(index, finalWord.length());
            }

            if(lastSyllable[0].equals(lastSyllable[1]) && lastSyllable[1].equals(lastSyllable[2]) && lastSyllable[2].equals(lastSyllable[3]))
                out.println("perfect");
            else if(lastSyllable[0].equals(lastSyllable[1]) && lastSyllable[2].equals(lastSyllable[3]))
                out.println("even");
            else if(lastSyllable[0].equals(lastSyllable[2]) && lastSyllable[1].equals(lastSyllable[3]))
                out.println("cross");
            else if(lastSyllable[0].equals(lastSyllable[3]) && lastSyllable[1].equals(lastSyllable[2]))
                out.println("shell");
            else
                out.println("free");
        }

        out.close();
    }

    public static class FastScanner {
        static BufferedReader br;
        static StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        static String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
            return st.nextToken();
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static char nextChar() throws IOException {
            return next().charAt(0);
        }

        static String nextLine() throws IOException {
            return br.readLine();
        }
    }
}
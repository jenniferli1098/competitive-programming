package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Metaprogramming {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        HashMap<String, Integer> dictionary = new HashMap<>();

        String input = sc.nextLine();

        while (input != null && input.length() != 0) {

            String[] tokens = input.split(" ");

            if (tokens[0].equals("define")) {

                int value = Integer.parseInt(tokens[1]);
                String word = tokens[2];

                dictionary.put(word, value);

            } else if (tokens[0].equals("eval")) {

                String first = tokens[1];
                char operator = tokens[2].charAt(0);
                String second = tokens[3];

                if (dictionary.containsKey(first) && dictionary.containsKey(second)) {
                    switch (operator) {
                        case '>':
                            out.println(dictionary.get(first) > dictionary.get(second));
                            break;
                        case '<':
                            out.println(dictionary.get(first) < dictionary.get(second));
                            break;
                        case '=':
                            out.println(dictionary.get(first).equals(dictionary.get(second)));
                            break;
                    }

                } else {
                    out.println("undefined");
                }

            }

            input = sc.nextLine();
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
            return next().charAt(0);
        }
    }
}
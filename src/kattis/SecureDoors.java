package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SecureDoors {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        int N = sc.nextInt();

        HashMap<String, Boolean> state = new HashMap<>();

        for (int i = 0; i < N; i++) {
            boolean entered = sc.next().equals("entry");
            String name = sc.next();

            if (!state.containsKey(name)) {
                state.put(name, entered);

                if (entered) {
                    out.println(name + " entered");
                } else {
                    out.println(name + " exited (ANOMALY)");
                }
            } else {
                if (!state.get(name) && entered) {
                    out.println(name + " entered");
                    state.put(name, entered);
                } else if (state.get(name) && !entered) {
                    out.println(name + " exited");
                    state.put(name, entered);
                } else if (state.get(name) && entered) {
                    out.println(name + " entered (ANOMALY)");
                } else if (!state.get(name) && !entered) {
                    out.println(name + " exited (ANOMALY)");
                } else {
                    out.println("I made an error.");
                }
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
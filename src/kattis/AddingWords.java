package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class AddingWords {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        HashMap<String, Integer> dictionary = new HashMap<>();

        String inputInstructions = sc.nextLine();

        do {
            String[] stepWords = inputInstructions.split(" ");

            if (stepWords[0].equals("def")) {
                dictionary.put(stepWords[1], Integer.parseInt(stepWords[2]));
            } else if (stepWords[0].equals("calc")) {
                String[] variables = new String[(stepWords.length - 1) / 2];
                Character[] operations = new Character[variables.length];

                for (int i = 1, x = 0; i < stepWords.length; i += 2) {
                    variables[x++] = stepWords[i];
                }

                for (int i = 2, x = 0; i < stepWords.length; i += 2) {
                    operations[x++] = stepWords[i].charAt(0);
                }

                // check validity before continuing
                boolean valid = true;

                for (int i = 0; i < variables.length; i++) {
                    if (!dictionary.containsKey(variables[i])) {
                        valid = false;
                        break;
                    }
                }

                // print output template
                for (int i = 0; i < variables.length; i++) {
                    out.print(variables[i] + " " + operations[i] + " ");
                }

                if (!valid) {
                    out.println("unknown");
                } else {
                    // calculate the actual sum
                    int sum = dictionary.get(variables[0]);

                    for (int i = 0; i < operations.length - 1; i++) {
                        int num = dictionary.get(variables[i + 1]);

                        if (operations[i] == '-') {
                            sum -= num;
                        } else {
                            sum += num;
                        }
                    }

                    if (dictionary.containsValue(sum)) {
                        for (Map.Entry<String, Integer> value : dictionary.entrySet()) {
                            if (value.getValue() == sum) {
                                out.println(value.getKey());
                            }
                        }
                    } else {
                        out.println("unknown");
                    }
                }
            } else if (inputInstructions.equals("clear")) {
                dictionary = new HashMap<>();
            }

            inputInstructions = sc.nextLine();
        } while (inputInstructions != null && inputInstructions.length() != 0);

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
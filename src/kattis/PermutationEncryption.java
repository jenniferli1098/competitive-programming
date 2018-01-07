package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PermutationEncryption {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {

        int keyLength = sc.nextInt();

        while (keyLength != 0) {

            StringBuilder decrypted = new StringBuilder(sc.nextLine());

            int[] keyCodes = new int[keyLength];

            for (int i = 0; i < keyLength; i++) {
                keyCodes[i] = sc.nextInt();
            }

            int repetitions = (int) (Math.ceil(decrypted.length() * 1.0 / keyLength)); // calculate number of times to run for loop

            StringBuilder encrypted = new StringBuilder("");

            int cIndex = 0;

            for (int i = 0; i < repetitions; i++) {
                char[] temp;

                if (cIndex + keyLength > decrypted.length()) {
                    temp = new char[keyLength];

                    for (int cnt = 0; cnt < keyLength; cnt++) {
                        temp[cnt] = ' ';
                    }

                    for (int j = cIndex, cnt = 0; j < decrypted.length(); j++, cnt++) {
                        temp[cnt] = decrypted.charAt(j);
                    }
                } else {
                    temp = decrypted.substring(cIndex, cIndex + keyLength).toCharArray();
                }

                encrypted.append(encrypt(temp, keyCodes));

                cIndex += keyLength;
            }

            out.println("\'" + encrypted.toString() + "\'");

            keyLength = sc.nextInt();
        }


        out.close();
    }

    public static StringBuilder encrypt(char[] toEncrypt, int[] code) {
        StringBuilder encrypted = new StringBuilder("");

        for (int i = 0; i < code.length; i++) {
            encrypted.append(toEncrypt[code[i] - 1]);
        }

        // DEBUG System.out.println(Arrays.toString(toEncrypt) + "     " + encrypted.toString());

        return encrypted;
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
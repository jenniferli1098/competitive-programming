package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class InOrOut {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        String curr = sc.nextLine();
        int testCase = 1;

        while(curr != null && curr.length() != 0) {
            out.print("Case " + testCase + ": " );

            String[] parseString = curr.split(" ");
            double x = Double.parseDouble(parseString[0]);
            double y = Double.parseDouble(parseString[1]);
            int r = Integer.parseInt(parseString[2]);

            boolean valid = true;
            Complex Zn = new Complex(0.0, 0.0);
            Complex c = new Complex(x, y);
            Complex Zn1 = c;

            for(int i = 0; i < r; i++) {
                Zn1 = Zn.square();
                Zn1.add(c);
                Zn = Zn1;

                if(Zn1.modulo() > 2.0) {
                    valid = false;
                    break;
                }
            }

            if(valid) {
                out.println("IN");
            } else {
                out.println("OUT");
            }

            ++testCase;
            curr = sc.nextLine();
        }

        out.close();
    }

    static class Complex {
        double real;
        double imaginary;

        public Complex(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public double modulo() {
            return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary , 2));
        }

        public Complex square() {
            double realComp = Math.pow(real, 2) - Math.pow(imaginary, 2);
            double imaginaryComp = 2 * real * imaginary;

            return new Complex(realComp, imaginaryComp);
        }

        public void add(Complex x) {
            real += x.real;
            imaginary += x.imaginary;
        }

        @Override
        public boolean equals(Object obj) {
            Complex x = (Complex) obj;

            return Math.abs(real - x.real) < 1.0e-10 && Math.abs(imaginary - x.imaginary) < 1.0e-10;
        }
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
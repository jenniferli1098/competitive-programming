import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCC_03_S1 {
    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int cPos = 1;
        int roll = sc.nextInt();

        while(true) {
            if(roll == 0) {
                out.println("You Quit!");
                break;
            }

            if(cPos + roll <= 100)
                cPos += roll;
            if(cPos == 54)
                cPos = 19;
            else if(cPos == 90)
                cPos = 48;
            else if(cPos == 99)
                cPos = 77;
            else if(cPos == 9)
                cPos = 34;
            else if(cPos == 40)
                cPos = 64;
            else if(cPos == 67)
                cPos = 86;

            out.println("You are now on square " + cPos);

            if(cPos == 100) {
                out.println("You Win!");
                break;
            }

            roll = sc.nextInt();
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
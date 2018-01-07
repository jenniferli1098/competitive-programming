package ccc;

import codebook.FastScanner;
import java.io.PrintWriter;

public class ccc15j1 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int m = in.nextInt();
        int d = in.nextInt();

        if(m == 2 && d == 18) {
            out.println("Special");
        } else if(m == 2 && d < 18 || m < 2) {
            out.println("Before");
        } else {
            out.println("After");
        }
    }
}

package ccc;

import codebook.FastScanner;
import java.io.PrintWriter;

public class ccc16j1 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int L = 0;

        for(int i = 0; i < 6; i++) {
            if(in.nextChar() == 'L') ++L;
        }

        int res = -1;

        if(L < 2) res = 1;
        else if(L < 4) res = 2;
        else if(L < 6) res = 3;

        out.println(res);
    }
}

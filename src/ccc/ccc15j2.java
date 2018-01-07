package ccc;

import codebook.FastScanner;
import java.io.PrintWriter;

public class ccc15j2 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String msg = in.nextLine();

        int happy = count(msg, ":-)");
        int sad = count(msg, ":-(");

        if(happy == 0 && sad == 0) {
            out.println("none");
        } else if(happy == sad) {
            out.println("unsure");
        } else if(happy > sad) {
            System.out.println("happy");
        } else {
            out.println("sad");
        }
    }

    static int count(String msg, String occurance) {
        int cnt = 0;

        int index = msg.indexOf(occurance);

        while(index > -1) {
            ++cnt;
            msg = msg.substring(index + 3);
            index = msg.indexOf(occurance);
        }

        return cnt;
    }
}

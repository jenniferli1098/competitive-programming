package ccc;

import codebook.FastScanner;
import java.io.PrintWriter;

public class ccc16j4 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String[] input = in.nextLine().split(":");
        int hours = Integer.parseInt(input[0]);
        int mins = Integer.parseInt(input[1]);

        int target = 240;
        int cnt = 0;

        while(cnt < target) {
            ++mins;

            if(mins > 59) {
                hours++;
                mins = 0;
                hours %= 24;
            }

            if((hours >= 7 && (hours < 10 || hours == 10 && mins == 0)) || (hours >= 15 && (hours < 19 || hours == 19 && mins == 0))) cnt += 1;
            else cnt += 2;
        }

        out.printf("%02d:%02d", hours % 24, mins / 10 * 10 % 60);

        ++mins;
    }
}

package ccc;

import codebook.FastScanner;
import java.io.PrintWriter;

public class ccc16j2 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int[][] input = new int[4][4];

        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++) input[i][j] = in.nextInt();

        boolean isMagic = true;
        int sum = input[0][0] + input[0][1] + input[0][2] + input[0][3];

        for(int i = 0; i < 4; i++) {
            int cSum = 0;
            int sum2 = 0;

            for(int j = 0; j < 4; j++) {
                cSum += input[i][j];
                sum2 += input[j][i];
            }

            if(cSum != sum || sum2 != sum) {
                isMagic = false;
            }
        }

        if(isMagic) out.println("magic");
        else out.println("not magic");
    }
}

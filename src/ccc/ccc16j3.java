package ccc;

import codebook.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class ccc16j3 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        char[] chars = in.nextLine().toCharArray();
        int max = 1;

        for(int i = 0; i < chars.length; i++) {
            for(int j = i + 1; j < chars.length + 1; j++) {
                if(isPalindrome(Arrays.copyOfRange(chars, i, j)))
                    if(j - i > max)
                        max = j - i;
            }
        }

        out.println(max);
    }

    boolean isPalindrome(char[] chars) {
        for(int i = 0; i < chars.length; i++) if(chars[i] != chars[chars.length - i - 1]) return false;

        return true;
    }
}

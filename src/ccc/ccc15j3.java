package ccc;

import codebook.FastScanner;

import java.io.PrintWriter;
import java.util.ArrayList;

public class ccc15j3 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        char[] input = in.nextLine().toCharArray();

        StringBuilder print = new StringBuilder("");

        for (char a : input) {
            print.append(a);

            if (!isVowel(a)) {
                print.append(closestVowel(a) + closestConsonant(a));
            }
        }

        out.println(print);
    }

    static String closestConsonant(char x) {
        ArrayList<Character> consonants = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            char current = (char) ('a' + i);

            if (!isVowel(current)) {
                consonants.add(current);
            }
        }

        int index = consonants.indexOf(x) + 1;

        if (index == consonants.size()) index--;

        return Character.toString(consonants.get(index));
    }

    static char closestVowel(char x) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        int[] diffs = new int[5];

        int min = Integer.MAX_VALUE;
        int index = Integer.MAX_VALUE;

        for (int cnt = 0; cnt < 5; cnt++) {
            diffs[cnt] = Math.abs(x - vowels[cnt]);

            if (diffs[cnt] < min) {
                min = diffs[cnt];
                index = cnt;
            }
        }

        return (char) vowels[index];
    }

    static boolean isVowel(char x) {
        return "aeiou".indexOf(x) > -1;
    }
}

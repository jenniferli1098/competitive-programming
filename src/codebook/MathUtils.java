package codebook;

import java.util.ArrayList;

public class MathUtils {
    static final double EPS = 1.0e-9;

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, b % a);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static int fast_pow(int x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n % 2 != 0) {
            return x * fast_pow(x, n - 1);
        }

        int evp = fast_pow(x, n / 2);
        return evp * evp;
    }

    static ArrayList generatePrimes(int n) {
        boolean[] isMarked = new boolean[n + 1];
        ArrayList<Integer> primes = new ArrayList<>();

        int i = 2;

        for(; i * i <= n; i++) {
            if (!isMarked[i]) {
                primes.add(i);

                for (int j = i; j <= n; j += i)
                    isMarked[j] = true;

                isMarked[i] = true;
            }
        }

        for(; i <= n; i++)
            if(!isMarked[i]) primes.add(i);

        return primes;
    }
}

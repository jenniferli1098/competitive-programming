package codebook;

import java.util.Arrays;

public class RangeQueries {
    public static void main(String[] args) {
        int[] arr = {1, 0, 7, 8, 5, 9, 3};
    }

    static class RangeQuery {
        int[] query;

        public RangeQuery(int[] arr) {
            this.query = new int[arr.length];
            this.query[0] = arr[0];

            for (int i = 1; i < arr.length; i++) {
                this.query[i] = this.query[i - 1] + arr[i];
            }
        }

        public int sumFrom(int min, int max) {
            if (min > max) {
                int temp = max;
                max = min;
                min = temp;
            }

            if (min == 0) {
                return sumFrom(max);
            }

            return this.query[max] - this.query[min - 1];
        }

        public int sumFrom(int max) {
            return this.query[max];
        }

        public void debug() {
            System.out.println(Arrays.toString(this.query));
        }
    }
}
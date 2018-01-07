package kattis;

import codebook.FastScanner;

import java.io.PrintWriter;
import java.util.Arrays;

public class CoastLength {
    static int M;
    static int N;

    static int[][] map;
    static boolean[][] visited;
    static int coastLength;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        M = in.nextInt();
        N = in.nextInt();

        map = new int[M + 2][N + 2];
        visited = new boolean[M + 2][N + 2];
        coastLength = 0;

        for (int i = 0; i < M + 2; i++) {
            Arrays.fill(map[i], 0);
        }

        for (int i = 1; i <= M; i++) {
            char[] chars = in.nextLine().toCharArray();

            for (int j = 1; j <= N; j++) {
                map[i][j] = chars[j - 1] == '0' ? 0 : 1;
            }
        }

        dfsWater(0, 0);

        out.println(coastLength);
    }

    public void dfsWater(int row, int col) {
        if (!(row >= 0 && row <= M + 1 && col >= 0 && col <= N + 1)) {
            return;
        }

        if (visited[row][col]) {
            return;
        }

        if (map[row][col] == 1) {
            ++coastLength;
            return;
        }

        visited[row][col] = true;

        Point[] ps = getNeighbours(row, col);

        for (Point p : ps) {
            dfsWater(p.x, p.y);
        }
    }

    static Point[] getNeighbours(int row, int col) {
        Point[] ns = new Point[4];
        ns[0] = new Point(row - 1, col);
        ns[1] = new Point(row + 1, col);
        ns[2] = new Point(row, col - 1);
        ns[3] = new Point(row, col + 1);
        return ns;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

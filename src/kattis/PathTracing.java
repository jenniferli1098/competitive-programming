package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class PathTracing {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        Stack<Point> moves = new Stack<>();
        moves.add(new Point(0, 0));

        String curr = sc.nextLine();

        while (curr != null && curr.length() != 0) {
            switch (curr) {
                case "down":
                    moves.add(new Point(moves.peek().x, moves.peek().y - 1));
                    break;
                case "up":
                    moves.add(new Point(moves.peek().x, moves.peek().y + 1));
                    break;
                case "right":
                    moves.add(new Point(moves.peek().x + 1, moves.peek().y));
                    break;
                case "left":
                    moves.add(new Point(moves.peek().x - 1, moves.peek().y));
                    break;
            }

            curr = sc.nextLine();
        }

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Point p : moves) {
            if (p.x > maxX) maxX = p.x;
            if (p.x < minX) minX = p.x;
            if (p.y > maxY) maxY = p.y;
            if (p.y < minY) minY = p.y;
        }

        int xDimensions = Math.abs(maxX - minX) + 1;
        int yDimensions = Math.abs(maxY - minY) + 1;

        for(Point p : moves) {
            p.x -= minX;
            p.y -= maxY;
        }

        char[][] print = new char[yDimensions][xDimensions];

        for(int i = 0; i < yDimensions; i++) {
            Arrays.fill(print[i], ' ');
        }

        for(Point p : moves) {
            print[Math.abs(p.y)][p.x] = '*';
        }

        print[Math.abs(maxY)][-minX] = 'S';
        print[Math.abs(moves.peek().y)][moves.peek().x] = 'E';

        drawBorder(xDimensions + 2);

        for (int y = 0; y < yDimensions; y++) {
            out.print("#");

            for (int x = 0; x < xDimensions; x++) {
                out.print(print[y][x]);
            }

            out.println("#");
        }

        drawBorder(xDimensions + 2);

        out.close();
    }

    static void drawBorder(int length) {
        for (int i = 0; i < length; i++) {
            out.print("#");
        }

        out.println();
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "X: " + x + " Y: " + y;
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        char nextChar() {
            return next().charAt(0);
        }
    }
}
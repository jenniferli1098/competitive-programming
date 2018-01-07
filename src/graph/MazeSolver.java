package graph;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MazeSolver {
    static int[][] map;
    static boolean[][] visited;
    static Point start;
    static int maxRow;
    static int maxCol;

    public static void main(String[] args) {
        readFile();

        try {
            dfs(start.x, start.y);
            System.out.println("No route found.");
        } catch (RuntimeException e) {
            System.out.println("Route found!");
        }
    }

    static void dfs(int row, int col) {
        if(visited[row][col] || map[row][col] == 1) return;
        if(map[row][col] == 3) throw new RuntimeException();

        visited[row][col] = true;
        Point[] neighbours = new Point[4];
        neighbours[0] = row == 0 ? null : new Point(row - 1, col);
        neighbours[1] = row + 1 == maxRow ? null : new Point(row + 1, col);
        neighbours[2] = col == 0 ? null : new Point(row, col - 1);
        neighbours[3] = col + 1 == maxCol ? null : new Point(row, col + 1);

        for(Point p : neighbours) {
            if(p != null) {
                dfs(p.x, p.y);
            }
        }
    }

    static void readFile() {
        List<String> lines = new ArrayList<>();
        maxRow = 0;

        try {
            Scanner sc = new Scanner(new File("C:\\Users\\Shehryar\\Documents\\GitHub\\kattis-solutions\\src\\graph\\maze.txt"));

            while((sc.hasNextLine())) {
                ++maxRow;
                lines.add(sc.nextLine());
            }

            maxCol = lines.get(0).split(" ").length;

            map = new int[maxRow][maxCol];
            visited = new boolean[maxRow][maxCol];

            for(int i = 0; i < maxRow; i++) {
                String[] rawString = lines.get(i).split(" ");

                for(int j = 0; j < maxCol; j++) {
                    int num = Integer.parseInt(rawString[j]);
                    map[i][j] = num;

                    if(num == 2) start = new Point(i, j);
                }
            }

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

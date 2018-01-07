package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Natrij {

    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        String intialTime = sc.nextLine();
        String finalTime = sc.nextLine();

        int initialSeconds = toMinutes(parseTime(intialTime));
        int finalSeconds = toMinutes(parseTime(finalTime));

        int minTime = min(initialSeconds, finalSeconds);

        if (finalSeconds == initialSeconds) {
            out.println("24:00:00");
        } else {
            out.println(timeString(minTime));
        }

        out.close();
    }

    public static int min(int initialSeconds, int finalSeconds) {
        return Math.abs(86400 - initialSeconds + finalSeconds);
    }

    public static String timeString(int seconds) {
        int hours = seconds / 3600 % 24;
        seconds -= hours * 3600;
        int minutes = seconds / 60 % 60;
        seconds %= 60;

        return ((hours > 9 ? hours : "0" + hours) + ":" + (minutes > 9 ? minutes : "0" + minutes) + ":" + (seconds > 9 ? seconds : "0" + seconds));
    }

    public static int[] parseTime(String sTime) {
        String[] split = sTime.split(":");
        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])};
    }

    public static int toMinutes(int[] time) {
        return time[0] * 3600 + time[1] * 60 + time[2];
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
            return nextLine().charAt(0);
        }
    }
}
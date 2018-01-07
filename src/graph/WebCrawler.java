package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    public static void main(String[] args) {
        bfs("http://www.bing.ca");
    }

    private static void bfs(String start) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.remove();
            String rawHTML = readURL(current);

            String regexExpression = "http://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexExpression);
            Matcher matcher = pattern.matcher(rawHTML);

            while (matcher.find()) {
                String found = matcher.group();

                if (!visited.contains(found)) {
                    visited.add(found);
                    System.out.println("Website has been found: " + found);
                    queue.add(found);
                }
            }

        }
    }

    private static String readURL(String v) {
        StringBuilder raw = new StringBuilder("");

        try {
            URL url = new URL(v);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String input = "";

            while ((input = br.readLine()) != null) {
                raw.append(input);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return raw.toString();
    }
}
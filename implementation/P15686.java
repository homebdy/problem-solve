package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P15686 {

    static int m;
    static int n;
    static List<Node> chickens = new ArrayList<>();
    static List<Node> houses = new ArrayList<>();
    static boolean[] open;
    static int[][] graph;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    chickens.add(new Node(i, j));
                } else if (graph[i][j] == 1) {
                    houses.add(new Node(i, j));
                }
            }
        }
        open = new boolean[chickens.size()];
        find(0, 0);

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void find(int count, int now) {
        if (count == m) {
            result = Math.min(result, calculateDistance());
            return;
        }
        for (int i = now; i < chickens.size(); i++) {
            open[i] = true;
            find(count + 1, i + 1);
            open[i] = false;
        }
    }

    static int calculateDistance() {
        int d = 0;
        for (Node house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (open[i]) {
                    minDistance = Math.min(minDistance, Math.abs(chickens.get(i).x - house.x)
                            + Math.abs(chickens.get(i).y - house.y));
                }
            }
            d += minDistance;
        }
        return d;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}

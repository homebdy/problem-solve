package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2568 {

    static int n;
    static int[][] graph;
    static int result = Integer.MIN_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] > max) {
                    max = graph[i][j];
                }
            }
        }

        for (int i = 0; i < max; i++) {
            solution(i);
        }
        sb.append(result).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void solution(int rain) {
        visited = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] > rain && !visited[i][j]) {
                    bfs(new Node(i, j), rain);
                    count++;
                }
            }
        }

        if (count > result) {
            result = count;
        }
    }

    private static void bfs(Node start, int rain) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }
                if (graph[nx][ny] > rain) {
                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

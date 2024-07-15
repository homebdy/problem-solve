package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14889 {

    static int n;
    static int[] start;
    static boolean[] visited;
    static int[][] graph;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        start = new int[n / 2];
        visited = new boolean[n];
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0, 0);

        sb.append(result).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void combination(int depth, int member) {
        if (depth == n / 2) {
            result = Math.min(result, diff());
            return;
        }
        for (int i = member; i < n; i++) {
            visited[i] = true;
            combination(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    private static int diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i] && visited[j]) {
                    start += graph[i][j];
                } else if (!visited[i] && !visited[j]) {
                    link += graph[i][j];
                }
            }
        }
        return Math.abs(start - link);
    }
}

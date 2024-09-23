import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[e].add(s);
            graph[s].add(e);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }

        dfs(sb, v);
        sb.append("\n");

        visited = new boolean[n + 1];
        bfs(sb, v);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(StringBuilder sb, int v) {
        sb.append(v).append(" ");
        visited[v] = true;
        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(sb, next);
            }
        }
    }

    private static void bfs(StringBuilder sb, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            for (int next : graph[now]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}

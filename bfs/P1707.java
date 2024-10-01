import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1707 {

    private static List<Integer>[] graph;
    private static int[] visited;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            visited = new int[v + 1];
            graph = new ArrayList[v + 1];
            for (int j = 1; j < v + 1; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                graph[n1].add(n2);
                graph[n2].add(n1);
            }

            boolean bipartite = false;
            for (int j = 1; j < v + 1; j++) {
                if (visited[j] == 0) {
                    bipartite = isBipartite(j);
                }
                if (!bipartite) {
                    break;
                }
            }
            if (bipartite) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean isBipartite(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int nextColor = 1;
            if (visited[now] == 1) {
                nextColor = -1;
            }
            for (int next : graph[now]) {
                if (visited[next] == 0) {
                    visited[next] = nextColor;
                    queue.offer(next);
                    continue;
                }
                if (visited[next] == visited[now]) {
                    return false;
                }
            }
        }
        return true;
    }
}

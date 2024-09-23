import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1167 {

    static List<Node>[] graph;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int val = Integer.parseInt(st.nextToken());
                if (val == -1) {
                    break;
                }
                int d = Integer.parseInt(st.nextToken());
                graph[node].add(new Node(val, d));
            }
        }

        Node max = bfs(1, n);
        Node result = bfs(max.val, n);
        sb.append(result.distance);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static Node bfs(int start, int n) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(new Node(start, 0));
        visited[start] = true;
        Node max = new Node(0, 0);
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.distance > max.distance) {
                max = now;
            }
            for (Node next : graph[now.val]) {
                if (!visited[next.val]) {
                    q.offer(new Node(next.val, now.distance + next.distance));
                    visited[next.val] = true;
                }
            }
        }
        return max;
    }

    static class Node {
        int val;
        int distance;

        public Node(int val, int distance) {
            this.val = val;
            this.distance = distance;
        }
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P1922 {

    static int n;
    static List<Edge>[] edges;


    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        edges = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edges[n1].add(new Edge(n2, d));
            edges[n2].add(new Edge(n1, d));
        }
        sb.append(calculateShortest(1));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int calculateShortest(int start) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(new Edge(start, 0));
        int answer = 0;
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            if (visited[now.e]) {
                continue;
            }
            visited[now.e] = true;
            answer += now.d;
            for (Edge edge : edges[now.e]) {
                if (!visited[edge.e]) {
                    queue.offer(edge);
                }
            }
        }
        return answer;
    }

    static class Edge implements Comparable<Edge> {
        int e;
        int d;

        public Edge(int e, int d) {
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            return this.d - o.d;
        }
    }
}

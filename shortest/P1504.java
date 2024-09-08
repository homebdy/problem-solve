import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P1504 {

    static int n;
    static List<Edge>[] edges;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edges[n1].add(new Edge(n2, d));
            edges[n2].add(new Edge(n1, d));
        }
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int[] startFromFirst = dijkstra(1);
        int[] startFromN1 = dijkstra(n1);
        int[] startFromN2 = dijkstra(n2);

        int d1 = startFromFirst[n1] + startFromN1[n2] + startFromN2[n];
        int d2 = startFromFirst[n2] + startFromN2[n1] + startFromN1[n];

        if (startFromFirst[n1] == Integer.MAX_VALUE ||
                startFromN1[n2] == Integer.MAX_VALUE || startFromN2[n] == Integer.MAX_VALUE) {
            d1 = Integer.MAX_VALUE;
        }
        if (startFromFirst[n2] == Integer.MAX_VALUE ||
                startFromN1[n] == Integer.MAX_VALUE || startFromN2[n1] == Integer.MAX_VALUE) {
            d2 = Integer.MAX_VALUE;
        }
        int answer = Math.min(d1, d2);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int[] dijkstra(int start) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(start, 0));
        distance[start] = 0;
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            for (Edge next : edges[now.e]) {
                if (distance[next.e] > distance[now.e] + next.d) {
                    distance[next.e] = distance[now.e] + next.d;
                    queue.offer(new Edge(next.e, distance[now.e] + next.d));
                }
            }
        }
        return distance;
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

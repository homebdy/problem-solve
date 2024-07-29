import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P1238_dij {

    static int n;
    static int x;
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        List<Road>[] to = new ArrayList[n + 1];
        List<Road>[] from = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            to[i] = new ArrayList<>();
            from[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            to[s].add(new Road(e, d));
            from[e].add(new Road(s, d));
        }

        int[] distacneToX = dijkstra(to);
        int[] distanceToI = dijkstra(from);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (i == x) {
                continue;
            }
            max = Math.max(max, distacneToX[i] + distanceToI[i]);
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int[] dijkstra(List<Road>[] roads) {
        PriorityQueue<Road> queue = new PriorityQueue<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        queue.offer(new Road(x, 0));
        distance[x] = 0;
        while (!queue.isEmpty()) {
            Road now = queue.poll();
            if (distance[now.e] != Integer.MAX_VALUE) {
                for (Road next : roads[now.e]) {
                    if (distance[next.e] > next.d + distance[now.e]) {
                        distance[next.e] = distance[now.e] + next.d;
                        queue.offer(new Road(next.e, distance[next.e]));
                    }
                }
            }
        }
        return distance;
    }

    static class Road implements Comparable<Road> {
        int e;
        int d;

        public Road(int e, int d) {
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Road o) {
            return this.d - o.d;
        }
    }
}

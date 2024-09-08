import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P1922_kruskal {

    static int n;
    static List<Edge> edges = new ArrayList<>();
    static int[] parents;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, e, d));
        }

        parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        Collections.sort(edges);
        int answer = 0;
        for (int i = 0; i < m; i++) {
            Edge edge = edges.get(i);
            if (find(edge.s) == find(edge.e)) {
                continue;
            }
            answer += edge.d;
            union(edge.s, edge.e);
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parents[b] = a;
    }

    static int find(int n) {
        if (n == parents[n]) {
            return n;
        }
        return parents[n] = find(parents[n]);
    }

    static class Edge implements Comparable<Edge> {

        int s;
        int e;
        int d;

        public Edge(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            return this.d - o.d;
        }
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1967 {

    static List<Node>[] edges;
    static int max = 0;
    static boolean[] visited;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        edges = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edges[s].add(new Node(e, d));
            edges[e].add(new Node(s, d));
        }
        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            dfs(i, 0);
        }

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int n, int d) {
        visited[n] = true;
        max = Math.max(max, d);
        for (Node next : edges[n]) {
            if (!visited[next.e]) {
                dfs(next.e, d + next.d);
            }
        }
    }

    static class Node {
        int e;
        int d;

        public Node(int e, int d) {
            this.e = e;
            this.d = d;
        }
    }
}

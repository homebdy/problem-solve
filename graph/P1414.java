import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1414 {

    static int[] parent;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int total = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                int length = 0;
                if (input.charAt(j) >= 'a') {
                    length = input.charAt(j) - 'a' + 1;
                } else if (input.charAt(j) >= 'A') {
                    length = input.charAt(j) - 'A' + 27;
                }
                if (length != 0) {
                    queue.offer(new Edge(i, j, length));
                }
                total += length;
            }
        }

        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            if (find(now.s) == find(now.e) || now.s == now.e) {
                continue;
            }
            union(now.s, now.e);
            total -= now.d;
        }

        boolean isConnected = true;
        for (int i = 0; i < n - 1; i++) {
            if (find(parent[i]) != find(parent[i + 1])) {
                isConnected = false;
                break;
            }
        }
        if (isConnected) {
            sb.append(total);
        } else {
            sb.append(-1);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
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

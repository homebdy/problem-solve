import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1068 {

    static int n;
    static List<Integer>[] graph;
    static boolean[] isDeleted;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n];
        isDeleted = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == -1) {
                root = i;
                continue;
            }
            graph[num].add(i);
        }

        int deleteNode = Integer.parseInt(br.readLine());
        delete(deleteNode);

        sb.append(countLeaf(root));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void delete(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        isDeleted[node] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                queue.offer(next);
                isDeleted[next] = true;
            }
        }

        for (List<Integer> graph : graph) {
            graph.removeIf(i -> isDeleted[i]);
        }
    }

    private static int countLeaf(int node) {
        if (isDeleted[node]) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(node);
        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (!visited[next] && !isDeleted[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
            if (graph[now].isEmpty()) {
                count++;
            }
        }
        return count;
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1325 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[n + 1];
        int[] count = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int next : graph[now]) {
                    if (!visited[next]) {
                        count[next]++;
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, count[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == max) {
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

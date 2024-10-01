import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] times = new int[n + 1];
        int[] answer = new int[n + 1];
        int[] degree = new int[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            while (num != -1) {
                graph[num].add(i);
                degree[i]++;
                num = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                answer[i] = times[i];
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next: graph[now]) {
                degree[next]--;
                answer[next] = Math.max(answer[next], answer[now] + times[next]);
                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5014 {

    static int f;
    static int u;
    static int d;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int result = bfs(s, g);
        if (result == -1) {
            sb.append("use the stairs");
        } else {
            sb.append(result);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static private int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[f + 1];
        Arrays.fill(visited, -1);
        queue.offer(start);
        visited[start] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == target) {
                return visited[target];
            }
            if (now + u <= f && visited[now + u] == -1) {
                queue.offer(now + u);
                visited[now + u] = visited[now] + 1;
            }
            if (now - d > 0 && visited[now - d] == -1) {
                queue.offer(now - d);
                visited[now - d] = visited[now] + 1;
            }
        }
        return -1;
    }
}

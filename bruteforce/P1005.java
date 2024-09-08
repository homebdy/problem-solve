import java.io.*;
import java.util.*;

public class P1005 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sb.append(solve()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] buildings = new int[n + 1];
        int[] degree = new int[n + 1];
        List<Integer>[] out = new ArrayList[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
            out[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            out[s].add(e);
            degree[e]++;
        }

        int w = Integer.parseInt(br.readLine());
        int[] answers = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                answers[i] = buildings[i];
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : out[now]) {
                answers[next] = Math.max(answers[next], answers[now] + buildings[next]);
                degree[next]--;
                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return answers[w];
    }
}

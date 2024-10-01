import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18352 {

    private static int n;
    private static List<Integer>[] graph;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }


        List<Integer> answer = getK(x, k);
        if (answer.isEmpty()) {
            sb.append("-1\n");
        } else {
            answer.forEach(a -> sb.append(a).append("\n"));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static List<Integer> getK(int start, int k) {
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (d[next] == Integer.MAX_VALUE) {
                    d[next] = d[now] + 1;
                    q.offer(next);
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (d[i] == k) {
                answer.add(i);
            }
        }
        Collections.sort(answer);
        return answer;
    }
}

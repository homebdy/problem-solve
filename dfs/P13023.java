import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P13023 {

    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean hasRelationship = false;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            dfs(i, 1);
            if (hasRelationship) {
                result++;
                break;
            }
        }
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int v, int depth) {
        if (depth == 5) {
            hasRelationship = true;
            return;
        }
        visited[v] = true;
        for(int next : graph[v]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[v] = false;
    }
}

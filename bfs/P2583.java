import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P2583 {

    static int m;
    static int n;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[m][n];
        visited = new boolean[m][n];
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    graph[j][l] = 1;
                }
            }
        }

        int count = 0;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) {
                    count++;
                    answer.add(bfs(new Node(j, i)));
                }
            }
        }
        sb.append(count).append("\n");
        Collections.sort(answer);
        answer.forEach(i -> sb.append(i).append(" "));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        int result = 1;
        queue.offer(start);
        visited[start.y][start.x] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[ny][nx]) {
                    continue;
                }
                if (graph[ny][nx] == 0) {
                    queue.offer(new Node(nx, ny));
                    visited[ny][nx] = true;
                    result++;
                }
            }
        }
        return result;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

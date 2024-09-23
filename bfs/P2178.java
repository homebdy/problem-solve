import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {

    static int n;
    static int m;
    static int[][] graph;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        sb.append(bfs(new Node(0, 0)));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        queue.offer(start);
        visited[start.y][start.x] = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[ny][nx] != 0) {
                    continue;
                }
                if (graph[ny][nx] == 1) {
                    visited[ny][nx] = visited[now.y][now.x] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
        return visited[n - 1][m - 1];
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

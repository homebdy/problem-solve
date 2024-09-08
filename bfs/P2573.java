import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2573 {

    static int n;
    static int m;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int count = 0;
        int land = 1;
        while (land == 1) {
            land = 0;
            melt();
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && graph[i][j] != 0) {
                        land++;
                        bfs(new Node(j, i));
                    }
                }
            }
            count++;
            if (land == 0) {
                count = 0;
            }
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void melt() {
        Queue<Node> queue = new LinkedList<>();
        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = graph[i][j];
                if (graph[i][j] != 0) {
                    queue.offer(new Node(j, i));
                }
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (copyMap[ny][nx] == 0 && graph[now.y][now.x] > 0) {
                    graph[now.y][now.x]--;
                }
            }
        }
    }

    private static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.y][start.x] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[ny][nx]) {
                    continue;
                }
                if (graph[ny][nx] != 0) {
                    queue.offer(new Node(nx, ny));
                    visited[ny][nx] = true;
                }
            }
        }
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

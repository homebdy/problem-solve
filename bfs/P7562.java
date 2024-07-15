import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {

    static int n;
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

             int result = bfs(new Node(startX, startY), new Node(endX, endY));
             sb.append(result).append("\n");
        }
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs(Node start, Node end) {
        if (start.equals(end)) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int[][] visited = new int[n][n];
        queue.offer(start);

        int[][] d = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            if (x == end.x && y == end.y) {
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] != 0) {
                    continue;
                }
                if (visited[nx][ny] == 0) {
                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = visited[x][y] + 1;
                }
            }
        }
        return visited[end.x][end.y];
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

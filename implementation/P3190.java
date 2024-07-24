import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P3190 {

    static int n;
    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Map<Integer, String> direction = new HashMap<>();

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], 0);
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            graph[y][x] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            direction.put(time, d);
        }

        sb.append(solve());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int solve() {
        int result = 0;
        int d = 0;
        int size = 1;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(1, 1));
        while (!queue.isEmpty()) {
            Node now = queue.peekLast();
            int x = now.x;
            int y = now.y;
            d = getNextDirection(result, d);

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx <= 0 || nx > n || ny <= 0 || ny > n || queue.contains(new Node(nx, ny))) {
                break;
            }
            if (graph[ny][nx] == 1) {
                size++;
                graph[ny][nx] = 0;
                queue.offer(new Node(nx, ny));
            } else {
                queue.poll();
                queue.offer(new Node(nx, ny));
            }
            result++;
        }
        return result + 1;
    }

    private static int getNextDirection(int time, int d) {
        if (direction.containsKey(time)) {
            String rotation = direction.get(time);
            if (rotation.contains("D")) {
                if (d != 3) {
                    return d + 1;
                }
                return 0;
            } else {
                if (d != 0) {
                    return d - 1;
                }
                return 3;
            }
        }
        return d;
    }

    private static boolean isFinish(int nx, int ny, Queue queue) {
        if (nx <= 0 || nx > n || ny <= 0 || ny > n) {
            return true;
        }
        for (int i = 0; i < queue.size(); i++) {

        }
        return false;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            if (node.x == this.x && node.y == this.y) {
                return true;
            }
            return false;
        }
    }
}

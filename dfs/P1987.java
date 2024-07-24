import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1987 {

    static int r;
    static int c;
    static String[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = 0;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph = new String[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                graph[i][j] = input[j];
            }
        }

        dfs(0, 0, "");

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y, String alphabet) {
        if (alphabet.contains(graph[y][x])) {
            return;
        }
        alphabet += graph[y][x];
        max = Math.max(max, alphabet.length());
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= c || ny < 0 || ny >= r || visited[ny][nx]) {
                continue;
            }
            dfs(nx, ny, alphabet);
        }
        visited[y][x] = false;
    }

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14499 {

    static int n;
    static int m;
    static int[][] graph;
    static int x;
    static int y;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dice = new int[7];

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(st.nextToken());
            int dice = move(d - 1);
            if (dice != -1) {
                sb.append(dice).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int move(int direction) {
        int nx = x + dx[direction];
        int ny = y + dy[direction];
        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
            return -1;
        }
        rollDice(direction);
        x = nx;
        y = ny;
        if (graph[y][x] == 0) {
            graph[y][x] = dice[6];
        } else {
            dice[6] = graph[y][x];
            graph[y][x] = 0;
        }

        return dice[3];
    }

    private static void rollDice(int direction) {
        int temp = dice[3];
        if (direction == 0) {
            dice[3] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[2];
            dice[2] = temp;

        } else if (direction == 1) {
            dice[3] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[4];
            dice[4] = temp;
        } else if (direction == 2) {
            dice[3] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[1];
            dice[1] = temp;
        } else {
            dice[3] = dice[1];
            dice[1] = dice[6];
            dice[6] = dice[5];
            dice[5] = temp;
        }
    }
}

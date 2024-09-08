import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13460 {

    static String[][] graph;
    static int n;
    static int m;
    static int result = Integer.MAX_VALUE;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new String[n][m];
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = input[j];
                if (graph[i][j].equals("R")) {
                    rx = j;
                    ry = i;
                } else if (graph[i][j].equals("B")) {
                    bx = j;
                    by = i;
                }
            }
        }

        bfs(rx, ry, bx, by, 0);
        if (result > 10) {
            result = -1;
        }
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int rx, int ry, int bx, int by, int count) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[n][m][n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        visited[ry][rx][by][bx] = true;
        queue.offer(new int[] {rx, ry, bx, by, count});
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            if (position[4] > 10) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int rnx = position[0];
                int rny = position[1];
                int bnx = position[2];
                int bny = position[3];
                while (!graph[rny + dy[i]][rnx + dx[i]].equals("#")) {
                    rnx += dx[i];
                    rny += dy[i];
                    if (graph[rny][rnx].equals("O")) {
                        break;
                    }
                }
                while (!graph[bny + dy[i]][bnx + dx[i]].equals("#")) {
                    bnx += dx[i];
                    bny += dy[i];
                    if (graph[bny][bnx].equals("O")) {
                        break;
                    }
                }
                if (graph[bny][bnx].equals("O")) {
                    continue;
                }
                if (graph[rny][rnx].equals("O")) {
                    result = Math.min(result, position[4] + 1);
                }

                if(rnx == bnx && rny == bny && !graph[rny][rnx].equals("O")) {
                    int red_move = Math.abs(rnx - position[0]) + Math.abs(rny - position[1]);
                    int blue_move = Math.abs(bnx - position[2]) + Math.abs(bny - position[3]);

                    if(red_move > blue_move) {
                        rnx -= dx[i];
                        rny -= dy[i];
                    } else {
                        bnx -= dx[i];
                        bny -= dy[i];
                    }
                }

                if(!visited[rny][rnx][bny][bnx]) {
                    visited[rny][rnx][bny][bnx] = true;
                    queue.add(new int[] {rnx, rny, bnx, bny, position[4] + 1});
                }
            }

        }
    }

    public static class P5014 {

        public static void main(String [] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }


    }
}

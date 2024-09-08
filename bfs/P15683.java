import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P15683 {

    static int n;
    static int m;
    static int[][] graph;
    static List<Node> cctvs = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static int[][][] dir = {{{0}}, {{0}, {1}, {2}, {3}}, {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}},
            {{0, 1, 2, 3}}};

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
                if (graph[i][j] != 0 && graph[i][j] != 6) {
                    cctvs.add(new Node(j, i));
                }
            }
        }
        dfs(0);
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth) {
        if (depth == cctvs.size()) {
            result = Math.min(result, getBlind());
            return;
        }
        Node cctv = cctvs.get(depth);
        int cctvNum = graph[cctv.y][cctv.x];
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = graph[i][j];
            }
        }
        for (int[] d : dir[cctvNum]) {
            for (int j : d) {
                if (j == 0) {
                    checkUp(cctv.x, cctv.y);
                } else if (j == 1) {
                    checkRight(cctv.x, cctv.y);
                } else if (j == 2) {
                    checkDown(cctv.x, cctv.y);
                } else if (j == 3) {
                    checkLeft(cctv.x, cctv.y);
                }
            }
            dfs(depth + 1);
            for (int i = 0; i < n; i++) {
                graph[i] = copy[i].clone();
            }
        }
    }

    private static void checkUp(int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (graph[i][x] == 6) {
                break;
            } else if (0 < graph[i][x] && graph[i][x] < 6) {
                continue;
            }
            graph[i][x] = 9;
        }
    }

    private static void checkDown(int x, int y) {
        for (int i = y + 1; i < n; i++) {
            if (graph[i][x] == 6) {
                break;
            } else if (0 < graph[i][x] && graph[i][x] < 6) {
                continue;
            }
            graph[i][x] = 9;
        }
    }

    private static void checkLeft(int x, int y) {
        for (int i = x - 1; i >= 0 ; i--) {
            if (graph[y][i] == 6) {
                break;
            } else if (0 < graph[y][i] && graph[y][i] < 6) {
                continue;
            }
            graph[y][i] = 9;
        }
    }

    private static void checkRight(int x, int y) {
        for (int i = x + 1; i < m ; i++) {
            if (graph[y][i] == 6) {
                break;
            } else if (0 < graph[y][i] && graph[y][i] < 6) {
                continue;
            }
            graph[y][i] = 9;
        }
    }
    private static int getBlind() {
        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    r++;
                }
            }
        }
        return r;
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

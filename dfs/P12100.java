import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12100 {

    static int n;
    static int[][] graph;
    static int answer = 0;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int depth) {
        if (depth == 5) {
            findMax();
            return;
        }

        int[][] now = new int[n][n];
        for (int i = 0; i < n; i++) {
            now[i] = graph[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            move(i);
            dfs(depth + 1);
            for (int j = 0; j < n; j++) {
                graph[j] = now[j].clone();
            }
        }
    }

    static void move(int d) {
        // 상
        if (d == 0) {
            for (int i = 0; i < n; i++) {
                int index = 0;
                int block = 0;
                for (int j = 0; j < n; j++) {
                    if (graph[j][i] != 0) {
                        if (block == graph[j][i]) {
                            graph[index - 1][i] = block * 2;
                            block = 0;
                            graph[j][i] = 0;
                        } else {
                            block = graph[j][i];
                            graph[j][i] = 0;
                            graph[index][i] = block;
                            index++;
                        }
                    }
                }
            }
        } else if (d == 1) {
            for (int i = 0; i < n; i++) {
                int index = n - 1;
                int block = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if(graph[j][i] != 0) {
                        if(block == graph[j][i]) {
                            graph[index + 1][i] = block * 2;
                            block = 0;
                            graph[j][i] = 0;
                        }
                        else {
                            block = graph[j][i];
                            graph[j][i] = 0;
                            graph[index][i] = block;
                            index--;
                        }
                    }
                }
            }
        } else if (d == 2) {
            for(int i = 0; i < n; i++) {
                int index = 0;
                int block = 0;
                for(int j = 0; j < n; j++) {
                    if(graph[i][j] != 0) {
                        if(block == graph[i][j]) {
                            graph[i][index - 1] = block * 2;
                            block = 0;
                            graph[i][j] = 0;
                        }
                        else {
                            block = graph[i][j];
                            graph[i][j] = 0;
                            graph[i][index] = block;
                            index++;
                        }
                    }
                }
            }
        } else if (d == 3) {
            for(int i = 0; i < n; i++) {
                int index = n - 1;
                int block = 0;
                for(int j = n - 1; j >= 0; j--) {
                    if(graph[i][j] != 0) {
                        if(block == graph[i][j]) {
                            graph[i][index + 1] = block * 2;
                            block = 0;
                            graph[i][j] = 0;
                        }
                        else {
                            block = graph[i][j];
                            graph[i][j] = 0;
                            graph[i][index] = block;
                            index--;
                        }
                    }
                }
            }
        }
    }

    static void findMax() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, graph[i][j]);
            }
        }
    }
}

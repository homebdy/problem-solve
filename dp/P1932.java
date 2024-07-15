package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1932 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = graph[1][1];
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + graph[i][j];
            }
        }

        int max = 0;
        for (int i = 1; i < dp[n].length; i++) {
            if (dp[n][i] > max) {
                max = dp[n][i];
            }
        }

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

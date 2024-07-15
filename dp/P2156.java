package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2156 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] graph = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = graph[1];
        if (n > 1) {
            dp[2] = graph[1] + graph[2];
        }

        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + graph[i], Math.max(dp[i - 1], dp[i - 3] + graph[i] + graph[i - 1]));
        }

        sb.append(dp[n]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

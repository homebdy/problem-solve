import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1328 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        long[][][] dp = new long[n + 1][n + 1][n + 1];
        dp[1][1][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][i][1] = 1;
            dp[i][1][i] = 1;
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    dp[i][j][k] = (dp[i - 1][j][k - 1] + dp[i - 1][j - 1][k] + dp[i - 1][j][k] * (i - 2)) % 1000000007;
                }
            }
        }
        sb.append(dp[n][l][r]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

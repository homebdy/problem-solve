import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11057 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n + 1][10];
        Arrays.fill(dp[1], 1);


        for (int i = 2; i < n + 1; i++) {
            long sum = 0;
            for (int j = 9; j >= 0; j--) {
                sum += dp[i - 1][j] % 10007;
                dp[i][j] = sum % 10007;
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n][i];
        }
        sb.append(result % 10007);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

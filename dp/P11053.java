import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11053 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < i; j++) {
                if (num > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

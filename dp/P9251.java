import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P9251 {
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        String a = br.readLine();
        String b = br.readLine();
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i < a.length() + 1; i++) {
            char now = a.charAt(i -1);
            for (int j = 1; j < b.length() + 1; j++) {
                char com = b.charAt(j - 1);
                if (now == com) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        sb.append(dp[a.length()][b.length()]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1256 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] combi = new int[n + m + 1][n + m + 1];
        combi[0][0] = 1;
        for (int i = 1; i < n + m + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    combi[i][j] = 1;
                    continue;
                }
                combi[i][j] = combi[i - 1][j - 1] + combi[i - 1][j];
                if (combi[i][j] > 1000000000) {
                    combi[i][j] = 1000000001;
                }
            }
        }

        if (combi[n + m][m] < k) {
            sb.append(-1);
        } else {
            while (!(n == 0 && m == 0)) {
                if (combi[n - 1 + m][m] >= k) {
                    sb.append("a");
                    n--;
                    continue;
                }
                sb.append("z");
                k -= combi[n - 1 + m][m];
                m--;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

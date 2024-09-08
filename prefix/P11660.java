import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P11660 {

    static int[][] sum;
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        sum = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                sum[i][j] = sum[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(getSum(x1, y1, x2, y2)).append("\n");
        }
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int getSum(int x1, int y1, int x2, int y2) {
        int result = 0;
        for (int i = x1; i < x2 + 1; i++) {
            result += (sum[i][y2] - sum[i][y1 - 1]);
        }
        return result;
    }
}

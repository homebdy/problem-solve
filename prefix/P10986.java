import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P10986 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] sum = new long[n + 1];
        long[] count = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            sum[i] += sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            sum[i] %= m;
            count[(int) sum[i]]++;
        }

        long result = 0;
        for (int i = 0; i < m; i++) {
            if (count[i] > 0) {
                result += (count[i] * (count[i] - 1)) / 2;
            }
        }

        sb.append(result + count[0]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

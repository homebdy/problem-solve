import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1300 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 0;
        int end = k;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(n, mid / i);
            }
            if (count < k) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

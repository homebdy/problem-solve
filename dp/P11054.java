import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11054 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] uDp = new int[n];
        int[] dDp = new int[n];
        Arrays.fill(uDp, 1);
        Arrays.fill(dDp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < i; j++) {
                if (num > nums[j]) {
                    uDp[i] = Math.max(uDp[i], uDp[j] + 1);
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            int num = nums[i];
            for (int j = n - 1; j > i; j--) {
                if (num > nums[j]) {
                    dDp[i] = Math.max(dDp[i], dDp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, uDp[i] + dDp[i] - 1);
        }

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

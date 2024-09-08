import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int s = 0;
            int e = n - 1;
            while (s < e) {
                int sum = nums[s] + nums[e];
                if (sum == num) {
                    if (s == i) {
                        s++;
                    } else if (e == i) {
                        e--;
                    } else {
                        count++;
                        break;
                    }
                } else if (sum < num) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

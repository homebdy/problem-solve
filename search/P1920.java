import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {

    static int n;
    static int[] nums;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int m = Integer.parseInt(br.readLine());
        int[] search = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            search[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            if (isExist(search[i])) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean isExist(int target) {
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (nums[m] > target) {
                e = m - 1;
            } else if (nums[m] < target) {
                s = m + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

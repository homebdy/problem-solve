import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class P1874 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int now = nums[i];
            if (num <= now) {
                while (num <= now) {
                    stack.push(num);
                    num++;
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            } else {
                int next = stack.pop();
                if (next > now) {
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }
                sb.append("-").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

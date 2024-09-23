import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            answer[i] = -1;
        }


        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int now = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] < now) {
                int index = stack.pop();
                answer[index] = now;
            }
            stack.push(i);
        }

        Arrays.stream(answer).forEach(i -> sb.append(i).append(" "));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2493 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] tops = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        Stack<Top> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int now = tops[i];
            while (true) {
                if (stack.isEmpty()) {
                    answer[i] = 0;
                    stack.push(new Top(i + 1, now));
                    break;
                }
                if (now <= stack.peek().height) {
                    answer[i] = stack.peek().index;
                    stack.push(new Top(i + 1, now));
                    break;
                } else {
                    stack.pop();
                }
            }
        }


        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class Top {
        int index;
        int height;

        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1744 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= 0) {
                negative.offer(num);
            } else {
                positive.offer(num);
            }
        }

        int result = 0;
        while (!positive.isEmpty()) {
            int num1 = positive.poll();
            if (positive.isEmpty()) {
                result += num1;
                continue;
            }
            int num2 = positive.poll();
            if (num1 == 1 || num2 == 1) {
                result += num1 + num2;
                continue;
            }
            result += num1 * num2;
        }

        while (!negative.isEmpty()) {
            int num1 = negative.poll();
            if (negative.isEmpty()) {
                result += num1;
                continue;
            }
            int num2 = negative.poll();
            result += num1 * num2;
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

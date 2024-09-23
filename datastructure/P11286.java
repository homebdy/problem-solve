import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class P11286 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);
            if (a == b) {
                if (o1 > o2) {
                    return 1;
                }
                return -1;
            } else {
                return a - b;
            }
        }));
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
                continue;
            }
            queue.offer(x);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

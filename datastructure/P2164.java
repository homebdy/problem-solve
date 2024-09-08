import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class P2164 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        IntStream.range(1, n + 1)
                .forEach(q::offer);

        while (q.size() > 1) {
            q.poll();
            q.offer(q.poll());
        }

        sb.append(q.poll());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

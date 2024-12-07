import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1715 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> cards = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            cards.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (cards.size() > 1) {
            int card1 = cards.poll();
            int card2 = cards.poll();
            answer += (card1 + card2);
            cards.offer(card1 + card2);
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

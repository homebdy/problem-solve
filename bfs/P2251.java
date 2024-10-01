import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P2251 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        TreeSet<Integer> answer = new TreeSet<>();
        Queue<Bottles> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[a + 1][b + 1][c + 1];
        queue.offer(new Bottles(0, 0, c));
        while (!queue.isEmpty()) {
            Bottles now = queue.poll();
            if (visited[now.first][now.second][now.third]) {
                continue;
            }

            if (now.first == 0) {
                answer.add(now.third);
            }
            visited[now.first][now.second][now.third] = true;

            // first -> second
            if (now.first + now.second > b) {
                queue.offer(new Bottles(now.first + now.second - b, b, now.third));
            } else {
                queue.offer(new Bottles(0, now.second + now.first, now.third));
            }

            // first -> third
            if (now.first + now.third > c) {
                queue.offer(new Bottles(now.first + now.third - c, now.second, c));
            } else {
                queue.offer(new Bottles(0, now.second, now.third + now.first));
            }

            // second -> first
            if (now.first + now.second > a) {
                queue.offer(new Bottles(a, now.first + now.second - a, now.third));
            } else {
                queue.offer(new Bottles(now.first + now.second, 0, now.third));
            }

            // second -> third
            if (now.second + now.third > c) {
                queue.offer(new Bottles(now.first, now.second + now.third - c, c));
            } else {
                queue.offer(new Bottles(now.first, 0, now.second + now.third));
            }

            // third -> first
            if (now.third + now.first > a) {
                queue.offer(new Bottles(a, now.second, now.first + now.third - a));
            } else {
                queue.offer(new Bottles(now.first + now.third, now.second, 0));
            }

            // third -> second
            if (now.third + now.second > b) {
                queue.offer(new Bottles(now.first, b, now.third + now.second - b));
            } else {
                queue.offer(new Bottles(now.first, now.second + now.third, 0));
            }
        }

        for (int num : answer) {
            sb.append(num).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class Bottles {
        int first;
        int second;
        int third;

        public Bottles(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}

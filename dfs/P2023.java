import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class P2023 {

    static int n;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        dfs(1, 2);
        dfs(1, 3);
        dfs(1, 5);
        dfs(1, 7);

        Collections.sort(answer);
        answer.forEach(i -> sb.append(i).append("\n"));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int num) {
        if (depth == n && isPrime(num)) {
                answer.add(num);
                return;
        }
        for (int i = 1; i <= 9; i++) {
            if (isPrime(num * 10 + i)) {
                dfs(depth + 1, num * 10 + i);
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

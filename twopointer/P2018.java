import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P2018 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 1];
        IntStream.range(1, n + 1)
                        .forEach(i -> num[i] = i);

        int left = 1;
        int right = 1;
        int sum = num[1];
        int count = 0;
        while (left <= right) {
            if (sum == n) {
                count++;
            }
            if (sum < n) {
                right++;
                sum += num[right];
            } else {
                sum -= num[left];
                left++;
            }
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

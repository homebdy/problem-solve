import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1541 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split("-");
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            int[] nums = Arrays.stream(input[i].split("\\+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (i == 0) {
                for (int num : nums) {
                    result += num;
                }
                continue;
            }
            for (int num : nums) {
                result -= num;
            }
        }
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

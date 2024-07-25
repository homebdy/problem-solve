import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1107 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] button = new boolean[10];
        Arrays.fill(button, true);
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int b = Integer.parseInt(st.nextToken());
                button[b] = false;
            }
        }

        int result = Math.abs(n - 100);
        for (int i = 0; i <= 999999; i++) {
            boolean isMade = true;
            String number = String.valueOf(i);
            for (int j = 0; j < number.length(); j++) {
                if (!button[number.charAt(j) - '0']) {
                    isMade = false;
                    break;
                }
            }
            if (isMade) {
                if (number.length() + Math.abs(n - Integer.parseInt(number)) < result) {
                    result = number.length() + Math.abs(n - Integer.parseInt(number));
                }
            }
        }
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

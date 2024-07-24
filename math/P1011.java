import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1011 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(solve(x, y)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int solve(int x, int y) {
        int distance = y - x;
        int max = (int)Math.sqrt(distance);

        if(max == Math.sqrt(distance)) {
            return max * 2 - 1;
        }
        else if(distance <= max * max + max) {
            return max * 2;
        }
        return max * 2 + 1;
    }
}

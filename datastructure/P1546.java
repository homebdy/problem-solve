import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1546 {
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        double[] scores = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            max = Math.max(max, score);
            scores[i] = score;
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scores[i] / max * 100;
        }
        sb.append(sum / n);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

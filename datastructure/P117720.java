import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P117720 {
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(input[i]);
        }
        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1629 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        long result = a;
        for (int i = 0; i < b; i++) {
            result *= b;
        }
        sb.append(result % c);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

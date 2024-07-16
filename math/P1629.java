import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1629 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        sb.append(pow(a, b, c));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static long pow(int a, int b, int c) {
        if (b == 0)
            return 1;

        long n = pow(a, b / 2, c);
        if (b % 2 == 0)
            return n * n % c;
        else
            return (n * n % c) * a % c;
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1074 {

    static int n;
    static int result;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);

        recursive(size, r, c);

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void recursive(int size, int r, int c) {
        if (size == 1) {
            return;
        }
        if (r < size / 2 && c < size / 2) {
            recursive(size / 2, r, c);
        } else if (r < size / 2 && c >= size / 2) {
            result += (size * size / 4);
            recursive(size / 2, r, c - (size / 2));
        } else if (r >= size / 2 && c < size / 2) {
            result += (size * size / 4) * 2;
            recursive(size / 2, r - (size / 2), c);
        } else {
            result += (size * size / 4) * 3;
            recursive(size / 2, r - (size / 2), c - (size / 2));
        }
    }
}

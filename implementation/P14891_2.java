import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14891_2 {

    static int[][] wheels = new int[4][8];

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = input.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            spin(n - 1, d);
        }
        sb.append(calculate());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void spin(int n, int d) {
        left(n - 1, -d);
        right(n + 1, -d);
        move(n, d);
    }

    private static void left(int n, int d) {
        if (n < 0 || wheels[n][2] == wheels[n + 1][6]) {
            return;
        }
        left(n - 1, -d);
        move(n, d);
    }

    private static void right(int n, int d) {
        if (n > 3 || wheels[n][6] == wheels[n - 1][2]) {
            return;
        }
        right(n + 1, -d);
        move(n, d);
    }


    static void move(int n, int d) {
        if (d == 1) {
            int temp = wheels[n][7];
            for (int i = 7; i > 0; i--) {
                wheels[n][i] = wheels[n][i - 1];
            }
            wheels[n][0] = temp;
        } else {
            int temp = wheels[n][0];
            for (int i = 0; i < 7; i++) {
                wheels[n][i] = wheels[n][i + 1];
            }
            wheels[n][7] = temp;
        }
    }

    private static int calculate() {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (wheels[i][0] == 1) {
                score += Math.pow(2, i);
            }
        }
        return score;
    }
}

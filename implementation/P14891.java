import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14891 {

    static int[][] wheels = new int[5][9];
    static int[] top = new int[5];

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Arrays.fill(top, 1);

        for (int i = 1; i < 5; i++) {
            String input = br.readLine();
            for (int j = 1; j < 9; j++) {
                wheels[i][j] = input.charAt(j - 1) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            spin(n, d);
            for (int j = 1; j < 5; j++) {
                System.out.print(top[j] + " ");
            }
            System.out.println();
        }

        sb.append(calculate());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void spin(int n, int d) {
        // 우선 회전하는 톱니바퀴인지 확인
        int[] isSpin = new int[5];
        isSpin[n] = d;
        for (int i = n - 1; i > 0; i--) {
            if (isSpin[i + 1] == 0) {
                continue;
            }
            int left = getRight(i);
            int right = getLeft(i + 1);
            if (left != right) {
                if (isSpin[i + 1] == 1) {
                    isSpin[i] = -1;
                    continue;
                }
                isSpin[i] = 1;
            }
        }
        for (int i = n + 1; i < 5; i++) {
            if (isSpin[i - 1] == 0) {
                continue;
            }
            int left = getRight(i - 1);
            int right = getLeft(i);
            if (left != right) {
                if (isSpin[i - 1] == 1) {
                    isSpin[i] = -1;
                    continue;
                }
                isSpin[i] = 1;
            }
        }

        // 나머지 톱니바퀴 반대 방향으로 회전
        for (int i = 1; i < 5; i++) {
            if (isSpin[i] == 0) {
                continue;
            }
            move(i, isSpin[i]);
        }
    }

    private static int getLeft(int n) {
        int t = top[n];
        if (t - 2 < 0) {
            return wheels[n][t + 6];
        }
        return wheels[n][t - 2];

    }

    private static int getRight(int n) {
        int t = top[n];
        if (t + 2 > 8) {
            return wheels[n][t - 6];
        }
        return wheels[n][t + 2];
    }

    private static void move(int n, int d) {
        if (d == 1) {
            top[n] -= 1;
            if (top[n] <= 0) {
                top[n] += 8;
            }
        } else {
            top[n] += 1;
            if (top[n] > 8) {
                top[n] -= 8;
            }
        }
    }

    private static int calculate() {
        int score = 0;
        for (int i = 1; i < 5; i++) {
            if (wheels[i][top[i]] == 1) {
                score += Math.pow(2, i - 1);
            }
        }
        return score;
    }
}

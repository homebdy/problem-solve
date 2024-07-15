package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14888 {

    static int[] nums;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        nums = new int[n];
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                int calculated = calculate(nums[0], nums[1], i);
                dfs(1, calculated);
                operator[i]++;
            }
        }

        sb.append(max).append("\n");
        sb.append(min).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static private void dfs(int depth, int result) {
        if (depth == n - 1) {
            if (max < result) {
                max = result;
            }
            if (min > result) {
                min = result;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                int calculated = calculate(result, nums[depth + 1], i);
                dfs(depth + 1, calculated);
                operator[i]++;
            }
        }
    }

    static int calculate(int a, int b, int operator) {
        if (operator == 0) {
            return a + b;
        } else if (operator == 1) {
            return a - b;
        } else if (operator == 2) {
            return a * b;
        }
        return a / b;
    }
}

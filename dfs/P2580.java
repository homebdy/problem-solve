import java.io.*;
import java.util.StringTokenizer;

public class P2580 {

    static int[][] graph = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    private static void sudoku(int x, int y) throws IOException {
        if (y == 9) {
            sudoku(x + 1, 0);
            return;
        }
        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(graph[i][j]).append(" ");
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            System.exit(0);
        }
        if (graph[y][x] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(x, y, i)) {
                    graph[y][x] = i;
                    sudoku(x, y + 1);
                }
            }
            graph[y][x] = 0;
            return;
        }
        sudoku(x, y + 1);
    }

    private static boolean isPossible(int x, int y, int number) {
        for (int i = 0; i < 9; i++) {
            if (graph[y][i] == number) {
                return false;
            }
            if (graph[i][x] == number) {
                return false;
            }
        }

        for (int i = y / 3 * 3; i < y / 3 * 3 + 3; i++) {
            for (int j = x / 3 * 3; j < x / 3 * 3 + 3; j++) {
                if (graph[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
}

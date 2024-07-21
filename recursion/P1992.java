import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1992 {

    static int[][] graph;
    static  StringBuilder sb = new StringBuilder();

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }
        recursion(0, 0, n);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void recursion(int x, int y, int size) {

        if (isAllSame(x, y, size)) {
            sb.append(graph[x][y]);
            return;
        }
        sb.append("(");
        recursion(x, y, size / 2);
        recursion(x, y + size / 2, size / 2);
        recursion(x + size / 2, y, size / 2);
        recursion(x + size / 2, y + size / 2, size / 2);
        sb.append(")");
    }

    private static boolean isAllSame(int x, int y, int size) {
        int value = graph[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != graph[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

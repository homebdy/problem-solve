import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1717 {

    static int[] parent;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (oper == 0) {
                union(a, b);
            } else if (oper == 1) {
                if (isSameGroup(a, b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a <= b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static boolean isSameGroup(int a, int b) {
        return find(a) == find(b);
    }

    private static int find(int number) {
        if (parent[number] == number) {
            return number;
        }
        return parent[number] = find(parent[number]);
    }
}

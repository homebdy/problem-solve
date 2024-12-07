import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1976 {

    static int[] parent;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int travel = Integer.parseInt(st.nextToken());
                if (travel == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean flag = true;
        int p = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < m; i++) {
            int index = Integer.parseInt(st.nextToken());
            if (find(index) != p) {
                sb.append("NO\n");
                flag = false;
                break;
            }
        }

        if (flag) {
            sb.append("YES\n");
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

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}

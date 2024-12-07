import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1043 {

    static int[] parent;

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        boolean[] truth = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }


        for (int i = 1; i <= n; i++) {
            int p = find(i);
            if (truth[p]) {
                truth[i] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < q; i++) {
            truth[Integer.parseInt(st.nextToken())] = true;
        }

        List<Integer>[] party = new ArrayList[m + 1];
        for (int i = 1; i <= m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            for (int j = 0; j < u; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < party[i].size(); j++) {
                for (int k = j; k < party[i].size(); k++) {
                    union(party[i].get(j), party[i].get(k));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (truth[i]) {
                int root = find(i);
                for (int j = 1; j < n + 1; j++) {
                    if (find(j) == root) {
                        truth[j] = true;
                    }
                }
            }
        }

        int count = m;
        for (int i = 1; i <= m; i++) {
            for (int participant: party[i]) {
                if (truth[participant]) {
                    count--;
                    break;
                }
            }
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int num) {
        if (num == parent[num]) {
            return num;
        }
        return parent[num] = find(parent[num]);
    }
}

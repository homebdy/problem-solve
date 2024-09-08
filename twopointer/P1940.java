import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P1940 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer> materials = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            materials.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(materials);

        int s = 0;
        int e = n - 1;
        int count = 0;
        while (s < e) {
            int sum = materials.get(s) + materials.get(e);
            if (sum == m) {
                count++;
                s++;
            } else if (sum < m) {
                s++;
            } else {
                e--;
            }
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

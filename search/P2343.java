import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2343 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] times = new int[n];
        st = new StringTokenizer(br.readLine());
        int s = 0;
        int e = 0;
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
            e += times[i];
            s = Math.max(s, times[i]);
        }

        int answer = Integer.MAX_VALUE;
        int blu = 0;
        int length = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            for (int time : times) {
                if (length + time > mid) {
                    blu++;
                    length = time;
                    continue;
                }
                length += time;
            }
            if (length > 0) {
                blu++;
            }

            if (blu <= m) {
                e = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                s = mid + 1;
            }
            blu = 0;
            length = 0;
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

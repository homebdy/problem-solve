import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P12891 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] essentialCount = new int[4];
        for (int i = 0; i < 4; i++) {
            essentialCount[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[4];
        for (int i = 0; i < p; i++) {
            if (dna.charAt(i) == 'A') {
                count[0]++;
            } else if (dna.charAt(i) == 'C') {
                count[1]++;
            } else if (dna.charAt(i) == 'G') {
                count[2]++;
            } else {
                count[3]++;
            }
        }
        int result = 0;
        if (isPassword(essentialCount, count)) {
            result++;
        }

        for (int i = p; i < s; i++) {
            int prev = i - p;
            if (dna.charAt(prev) == 'A') {
                count[0]--;
            } else if (dna.charAt(prev) == 'C') {
                count[1]--;
            } else if (dna.charAt(prev) == 'G') {
                count[2]--;
            } else {
                count[3]--;
            }

            if (dna.charAt(i) == 'A') {
                count[0]++;
            } else if (dna.charAt(i) == 'C') {
                count[1]++;
            } else if (dna.charAt(i) == 'G') {
                count[2]++;
            } else {
                count[3]++;
            }

            if (isPassword(essentialCount, count)) {
                result++;
            }
        }


        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static boolean isPassword(int[] essentialCount, int[] count) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if (essentialCount[i] > count[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}

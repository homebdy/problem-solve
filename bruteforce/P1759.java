import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759 {

    static int n;
    static int m;
    static String[] letters;
    static boolean[] visited;
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        letters = br.readLine().split(" ");
        Arrays.sort(letters);
        visited = new boolean[m];

        combi(0, 0, sb);
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void combi(int depth, int start, StringBuilder sb) {
        if (depth == n) {
            String s = "";
            for (int i = 0; i < m; i++) {
                if (visited[i]) {
                    s += letters[i];
                }
            }
            if (isContainVowel(s)) {
                sb.append(s).append("\n");
            }
            return;
        }
        for (int i = start; i < m; i++) {
            visited[i] = true;
            combi(depth + 1, i + 1, sb);
            visited[i] = false;
        }
    }

    static boolean isContainVowel(String s) {
        int vowel = 0;
        int consonant = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'o' || c == 'u' || c=='i') {
                vowel++;
            } else {
                consonant++;
            }
        }
        return vowel >= 1 && consonant >= 2;
    }
}

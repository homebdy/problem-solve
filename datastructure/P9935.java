import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class P9935 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String bomb = br.readLine();
        Stack<Character> answer = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            answer.push(input.charAt(i));
            if (answer.size() >= bomb.length()) {
                boolean isBomb = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (bomb.charAt(j) != answer.get(answer.size() - bomb.length() + j)) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb) {
                    for (int j = 0; j < bomb.length(); j++) {
                        answer.pop();
                    }
                }
            }
        }
        if (!answer.isEmpty()) {
            answer.forEach(sb::append);
        } else {
            sb.append("FRULA");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

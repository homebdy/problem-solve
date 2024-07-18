import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class P5430 {

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String operator = br.readLine();
            int n = Integer.parseInt(br.readLine());
            List<Integer> numbers = new ArrayList<>();
            String[] inputs = br.readLine()
                    .replace("[", "").replace("]", "")
                    .split(",");
            for (int j = 0; j < n; j++) {
                numbers.add(Integer.valueOf(inputs[j]));
            }
            if (validateOperators(operator, n)) {
                sb.append("error").append("\n");
                continue;
            }
            int rCount = 0;
            for (int j = 0; j < operator.length(); j++) {
                char op = operator.charAt(j);
                if (op == 'R') {
                    rCount++;
                } else if (op == 'D') {
                    if (rCount % 2 == 0) {
                        numbers.remove(0);
                    } else {
                        numbers.remove(numbers.size() - 1);
                    }
                }
            }

            sb.append("[");

            if (numbers.size() >= 1) {
                if (rCount % 2 == 0) {
                    for (int j = 0; j < numbers.size() - 1; j++) {
                        sb.append(numbers.get(j)).append(",");
                    }
                    sb.append(numbers.get(numbers.size() - 1));
                } else {
                    for (int j = numbers.size() - 1; j > 0; j--) {
                        sb.append(numbers.get(j)).append(",");
                    }
                    sb.append(numbers.get(0));
                }
            }
            sb.append("]");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean validateOperators(String operators, int n) {
        int dCount = 0;
        for (int i = 0; i < operators.length(); i++) {
            if (operators.charAt(i) == 'D') {
                dCount++;
            }
        }
        return n - dCount < 0;
    }
}

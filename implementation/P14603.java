import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14603 {

    static int n;
    static int m;
    static int[][] room;
    static int d;
    static int result = 0;
    static int[] dx = {0, 1, 0 , -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cleanRoom(c, r);
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void cleanRoom(int startX, int startY) {
        int x = startX;
        int y = startY;

        while (!isAllClean()) {
            if (room[y][x] == 0) {
                result++;
                room[y][x] = 2;
            }

            if (isDirty(x, y)) {
                for (int i = 0; i < 4; i++) {
                    turn();
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(0 <= ny && ny < n && 0 <= nx && nx< m &&room[ny][nx] == 0) {
                        x = nx;
                        y = ny;
                        break;
                    }
                }
            } else {
                int reverseDirection = reverse();
                int nx = x + dx[reverseDirection];
                int ny = y + dy[reverseDirection];
                if(0 <= ny && ny < n && 0 <= nx && nx< m) {
                    if (room[ny][nx] != 1) {
                        x = nx;
                        y = ny;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private static boolean isDirty(int x, int y) {
        boolean isDirty = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= ny && ny< n && 0 <= nx && nx < m) {
                if(room[ny][nx] == 0) {
                    isDirty = true;
                }
            }
        }
        return isDirty;
    }

    private static void turn() {
        if (d == 0) {
            d = 3;
            return;
        }
        d -= 1;
    }

    private static boolean isAllClean() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int reverse() {
        if (d == 0) {
            return 2;
        } else if (d == 1) {
            return 3;
        } else if (d == 2) {
            return 0;
        } else {
            return 1;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, ans = 0;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static int[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R][C];
        for (int r = 0; r < R; r++) {
            String rl = in.readLine();
            for (int c = 0; c < C; c++) {
                arr[r][c] = rl.charAt(c) - 'A';
            }
        }

        isVisit = new int[R][C];
        dfs(0, 0, 1, arr, 1 << arr[0][0]);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int cnt, int[][] arr, int check) {
        ans = Math.max(ans, cnt);
        if (ans == 26) return;

        isVisit[y][x] = check;

        for (int idx = 0; idx < 4; idx++) {
            int nx = x + dx[idx], ny = y + dy[idx];
            if (!isBound(ny, nx)
                    || (check & 1 << (arr[ny][nx])) != 0
                    || (check | 1 << arr[ny][nx]) == isVisit[ny][nx])
                continue;
            dfs(nx, ny, cnt + 1, arr, check | 1 << arr[ny][nx]);
        }
        return;
    }

    private static boolean isBound(int ny, int nx) {
        if (ny < 0 || ny >= R || nx < 0 || nx >= C)
            return false;
        return true;
    }
}
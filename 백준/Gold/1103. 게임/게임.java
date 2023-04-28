import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int ret = 0, N, M;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int r = 0; r < N; r++) {
            map[r] = in.readLine().toCharArray();
        }
        dp = new int[N][M];
        boolean[][] v = new boolean[N][M];
        v[0][0] = true;
        dfs(1, 0, 0, v);
        System.out.println(ret == Integer.MAX_VALUE ? -1 : ret);
    }

    private static void dfs(int cnt, int r, int c, boolean[][] v) {
        dp[r][c] = cnt;
        ret = Math.max(ret, cnt);

        int num = map[r][c] - '0';
        for (int i = 0; i < 4; i++) {
            int ny = r + num * dy[i], nx = c + num * dx[i];
            if ((ny < 0 || ny >= v.length || nx < 0 || nx >= v[0].length) || map[ny][nx] == 'H')
                continue;

            if (cnt < dp[ny][nx])
                continue;

            if (v[ny][nx]) {
                ret = Integer.MAX_VALUE;
                return;
            }

            v[ny][nx] = true;
            dfs(cnt + 1, ny, nx, v);
            v[ny][nx] = false;
        }
    }
}
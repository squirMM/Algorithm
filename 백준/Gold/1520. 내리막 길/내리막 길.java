import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map, dp;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = dfs(0, 0);
        System.out.println(ans);
    }

    private static int dfs(int y, int x) {
        if (y == N - 1 && x == M - 1) return 1;
        if (dp[y][x] != -1) return dp[y][x];

        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y, nx = dx[i] + x;
            if (!isBound(ny, nx) || map[y][x] <= map[ny][nx]) continue;
            dp[y][x] += dfs(ny, nx);
        }
        return dp[y][x];
    }

    private static boolean isBound(int ny, int nx) {
        if (ny >= N || ny < 0 || nx >= M || nx < 0)
            return false;
        return true;
    }
}
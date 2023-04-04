import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, ret = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] dp = new int[N][N][3];
        dp[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 1) continue;
                if (i == 0) {
                    if (j < 2) continue;
                    dp[i][j][0] = dp[i][j - 1][0];
                } else {
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                    if (map[i - 1][j] == 0 && map[i][j - 1] == 0)
                        dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }
        ret = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
        System.out.println(ret);
    }
}
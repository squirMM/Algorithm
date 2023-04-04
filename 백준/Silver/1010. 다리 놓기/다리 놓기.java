import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int N  = Math.max(a,b), R = Math.min(a,b);
            dp = new int[N + 1][R + 1];
            int ret = bonomial(N,R);
            sb.append(ret).append("\n");
        }
        System.out.println(sb);
    }

    private static int bonomial(int n, int r) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n][r];
    }
}
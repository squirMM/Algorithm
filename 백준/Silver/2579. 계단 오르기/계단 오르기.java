import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[] stairs = new int[N + 1];
        for (int i = 1; i <= N; i++)
            stairs[i] = Integer.parseInt(in.readLine());

        int[][] dp = new int[N + 1][3];
        for (int i = 0; i < N; i++) {
            dp[i + 1][0] = Math.max(dp[i][1], dp[i][2]);
            dp[i + 1][1] = dp[i][0] + stairs[i + 1];
            dp[i + 1][2] = dp[i][1] + stairs[i + 1];
        }

        System.out.println(Math.max(dp[N][1], dp[N][2]));
    }
}
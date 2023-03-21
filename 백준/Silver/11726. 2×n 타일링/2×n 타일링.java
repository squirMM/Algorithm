import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] dp = new int[N];
        dp[0] = 1;
        if (N != 1) dp[1] = 2;
        for (int i = 2; i < N; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
        System.out.println(dp[N - 1]);
    }
}
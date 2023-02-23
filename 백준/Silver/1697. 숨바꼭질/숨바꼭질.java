import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dp = new int[100_002];
//		Arrays.fill(dp,100_002);
		for (int i = 0; i < dp.length; i++) {
			dp[i] = Math.abs(i - N);
		}
		for (int i = 1; i <= 50000; i++) {
			dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
			dp[i * 2 + 1] = Math.min(dp[i * 2] + 1, dp[i * 2 + 1]);
			dp[i * 2 - 1] = Math.min(dp[i * 2] + 1, dp[i * 2 - 1]);
		}
		System.out.println(dp[K]);
	}
}
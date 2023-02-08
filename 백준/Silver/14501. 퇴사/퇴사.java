import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int MAX = 16;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] D = new int[MAX];
		int[] M = new int[MAX];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			D[i] = Integer.parseInt(st.nextToken());
			M[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[MAX];

		for (int i = 0; i < N; i++) {
			if (i + D[i] <= N)
				dp[i + D[i]] = Math.max(dp[i + D[i]], dp[i] + M[i]);
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}

		System.out.println(dp[N]);

	}
}
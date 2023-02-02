import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans = 0;
	static int MAX = 16;

	static int N = 0;
	static int[] D = new int[MAX];
	static int[] M = new int[MAX];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int day = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());

			D[i] = day;
			M[i] = money;
		}

		brute(0, 0);

		System.out.println(ans);

	}

	public static void brute(int date, int total) {
		if (date > N)
			return;

		if (date == N) {
			ans = Math.max(ans, total);
			return;
		}

		brute(date + D[date], total + M[date]);
		brute(date + 1, total);
	}
}

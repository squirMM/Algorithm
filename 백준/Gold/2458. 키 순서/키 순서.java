import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] arr = new boolean[N + 1][N + 1];
		int[] sum = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[e][s] = true;
			sum[e] += 1;
			sum[s] += 1;
		}
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k)
					continue;
				for (int j = 1; j <= N; j++) {
					if (i == j || j == k)
						continue;
					if (!arr[i][j] && arr[i][k] && arr[k][j] ) {
						sum[i] += 1;
						sum[j] += 1;
						arr[i][j] = true;
					}
					if(!arr[j][i] && arr[j][k] && arr[k][i]) {
						sum[i] += 1;
						sum[j] += 1;
						arr[j][i] = true;
					}
				}
			}
		}
		int ret = 0;
		for (int i = 1; i < sum.length; i++) {
			if (sum[i] == N - 1)
				ret++;
		}
		System.out.println(ret);
	}
}
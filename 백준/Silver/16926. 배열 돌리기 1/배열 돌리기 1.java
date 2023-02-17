import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static String[][] arr, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new String[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = st.nextToken();
			}
		}

		ans = new String[N][M];
		rotate(N-1, M-1);

		for (int i = 0; i < N; i++) {
			String join = String.join(" ", arr[i]);
			sb.append(join).append("\n");
		}
		System.out.println(sb);
	}

	private static void rotate(int n, int m) {
		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, -1, 0, 1 };

		int t = 0;
		while (n >= N / 2 && m >= M / 2) {
			int r = R % (2 * (n -t + m -t));
			while (r-- > 0) {
				int y = n, x = m;
				int pos = 0;
				String prev = arr[y][x];
				while (pos < 4) {
					int ny = y + dy[pos], nx = x + dx[pos];
					if (!isBound(ny, nx, n, m, t))
						pos += 1;
					else {
						String tmp = arr[ny][nx];
						arr[ny][nx] = prev;
						prev = tmp;
						y = ny; x = nx;
					}
				}
			}
			n -= 1;
			m -= 1;
			t += 1;
		}

	}

	private static boolean isBound(int ny, int nx, int n, int m, int t) {
		if (nx <t  || ny <t || nx > m || ny > n)
			return false;
		return true;
	}
}
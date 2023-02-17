import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N;
	static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				arr[y][x] = 1;
			}
			int ans = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (arr[r][c] == 0)
						continue;
					bfs(arr, r, c);
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

	private static void bfs(int[][] arr, int sy, int sx) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<>();

		arr[sy][sx] = 0;
		q.add(new int[] { sy, sx });
		while (!q.isEmpty()) {
			int[] poll = q.poll();

			for (int i = 0; i < direction.length; i++) {
				int nx = poll[1] + direction[i][1];
				int ny = poll[0] + direction[i][0];

				if (!isBound(ny, nx) || arr[ny][nx] == 0)
					continue;
				arr[ny][nx] = 0;
				q.add(new int[] { ny, nx });
			}
		}
	}

	private static boolean isBound(int ny, int nx) {
		// TODO Auto-generated method stub
		if (nx < 0 || nx == M || ny < 0 || ny == N) {
			return false;
		}
		return true;
	}

}
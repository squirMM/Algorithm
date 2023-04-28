import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N, M, max, ret = Integer.MIN_VALUE;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		max = (N - 1) * 10 + M - 1;
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);

		System.out.println(ret);
	}

	private static void dfs(int cnt) {
		if (cnt == 3) {
			bfs();
			return;
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					map[r][c] = 1;
					dfs(cnt + 1);
					map[r][c] = 0;
				}
			}
		}
	}

	private static void bfs() {
		int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

		int[][] copyMap = copy(map);
		
		Queue<int[]> q = new ArrayDeque<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (copyMap[r][c] == 2) {
					q.add(new int[] { r, c });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] poll = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = poll[0] + dy[i], nx = poll[1] + dx[i];
				if (!isBound(ny, nx) || copyMap[ny][nx] != 0)
					continue;
				copyMap[ny][nx] = 2;
				q.add(new int[] { ny, nx });
			}
		}
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (copyMap[r][c] == 0)
					cnt++;
			}
		}
		ret = Math.max(ret, cnt);
	}

	private static boolean isBound(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= M)
			return false;
		return true;
	}

	private static int[][] copy(int[][] realMap) {
		int[][] copyMap = new int[N][M];
		for (int r = 0; r < N; r++) {
			copyMap[r] = realMap[r].clone();
		}
		return copyMap;
	}
}
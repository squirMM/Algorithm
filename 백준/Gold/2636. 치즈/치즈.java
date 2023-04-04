import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr = null;
	static int R, C, total;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		total = 0;
		arr = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if (arr[r][c] == 1)
					total += 1;
			}
		}
		int ret = total, times = 0;
		while (total > 0) {
			bfs(0, 0);
			if (total > 0)
				ret = total;
			times += 1;
		}
		System.out.println(times + "\n" + ret);

	}

	private static void bfs(int r, int c) {
		arr[r][c] = 0;
		boolean[][] isVisit = new boolean[R][C];
		isVisit[r][c] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { r, c });

		int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, 1, -1 };

		while (!q.isEmpty()) {
			int[] poll = q.poll();

			for (int i = 0; i < dy.length; i++) {
				int ny = poll[0] + dy[i], nx = poll[1] + dx[i];
				if (!isBound(ny, nx) || isVisit[ny][nx])
					continue;
				isVisit[ny][nx] = true;
				if (arr[ny][nx] == 0) {
					q.add(new int[] { ny, nx });
				}
				if (arr[ny][nx] == 1) {
					total -= 1;
					arr[ny][nx] = 0;
				}
			}
		}
	}

	private static boolean isBound(int ny, int nx) {
		if (ny < 0 || ny >= R || nx < 0 || nx >= C)
			return false;
		return true;
	}
}
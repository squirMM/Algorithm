import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int M, N, ans;
	static int[][] box;
	static ArrayDeque<Integer[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		q = new ArrayDeque<>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
				if (box[r][c] == 1)
					q.add(new Integer[] { r, c, 0 });
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		int cnt = 0;
		int[] dc = { -1, 1, 0, 0, }, dr = { 0, 0, -1, 1 };

		while (!q.isEmpty()) {
			Integer[] poll = q.poll();
			cnt = Math.max(cnt, poll[2]);
			for (int i = 0; i < 4; i++) {
				int nr = poll[0] + dr[i], nc = poll[1] + dc[i];
				if (!isBound(nr, nc) || box[nr][nc] != 0)
					continue;
				box[nr][nc] = 1;
				q.add(new Integer[] { nr, nc, poll[2] + 1 });
			}
		}
		if (!checkBox())
			return -1;
		return cnt;
	}

	private static boolean checkBox() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (box[r][c] == 0)
					return false;
			}
		}
		return true;
	}

	private static boolean isBound(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M)
			return false;
		return true;
	}
}
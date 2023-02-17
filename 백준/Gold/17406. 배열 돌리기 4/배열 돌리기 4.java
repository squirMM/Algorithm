import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<int[]> permute = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][M + 1];
		for (int rows = 1; rows <= N; rows++) {
			st = new StringTokenizer(in.readLine());
			for (int col = 1; col <= M; col++) {
				arr[rows][col] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] ks = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			ks[i] = new int[] { r, c, s };
		}

		int ans = 5000;

		makePermutation(K, 0, new int[K], new boolean[K]);
		for (int i = 0; i < permute.size(); i++) {
			int[][] rotateArr = deepcopyArr(arr);
			for (int j : permute.get(i)) {
				rotateArr = rotateArr(ks[j][0], ks[j][1], ks[j][2], rotateArr);
			}
			ans = Math.min(ans, calculateMin(rotateArr));
		}

		System.out.println(ans);
	}

	private static int[][] deepcopyArr(int[][] arr) {
		int[][] copy = new int[arr.length][];
		for (int i = 0; i < arr.length; i++)
			copy[i] = arr[i].clone();
		return copy;
	}

	private static void makePermutation(int K, int cnt, int[] selected, boolean[] isVisit) {
		if (cnt == K) {
			permute.add(selected.clone());
			return;
		}
		for (int i = 0; i < K; i++) {
			if (isVisit[i])
				continue;
			selected[cnt] = i;
			isVisit[i] = true;
			makePermutation(K, cnt + 1, selected, isVisit);
			isVisit[i] = false;

		}
	}

	private static int calculateMin(int[][] arr) {
		int minSum = 5000;
		for (int rows = 1; rows < arr.length; rows++) {
			int sum = 0;
			for (int col = 1; col < arr[1].length; col++) {
				sum += arr[rows][col];
			}
			minSum = Math.min(sum, minSum);
		}
		return minSum;
	}

	private static int[][] rotateArr(int r, int c, int s, int[][] arr) {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		while (s > 0) {
			int x = c - s;
			int y = r - s;

			int pos = 0, prev = arr[y][x];
			while (pos < 4) {
				int nx = x + dx[pos], ny = y + dy[pos];
				if (!isBound(nx, ny, r, c, s))
					pos += 1;
				else {
					int tmp = arr[ny][nx];
					arr[ny][nx] = prev;
					prev = tmp;
					x = nx;
					y = ny;
				}
			}
			s--;
		}
		return arr;
	}

	private static boolean isBound(int nx, int ny, int r, int c, int s) {
		if (nx < c - s || nx > c + s || ny < r - s || ny > r + s)
			return false;
		return true;
	}
}
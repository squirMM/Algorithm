import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// map배열과 방문 체크 배열
	static boolean[][] map = new boolean[102][102], isVisit = new boolean[101][101];
	// nx, ny를 만들어 주기위한 배열
	static int[] dy = { 1, -1, 0, 0, }, dx = { 0, 0, 1, -1 };
	// 답 저장
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 개수
		int N = Integer.parseInt(in.readLine());

		// 시작점 담을 리스트
		List<Integer[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			// x좌표
			int c = Integer.parseInt(st.nextToken());
			// y좌표
			int r = Integer.parseInt(st.nextToken());
			list.add(new Integer[] { c, r });
			// map 생성
			createMap(c, r);
		}

		// 모든 시작점 순회
		for (Integer[] a : list)
			dfs(a[0], a[1]);
		
		System.out.println(ans);
	}

	private static void dfs(int x, int y) {
		// 이미 방문했다면 return
		if (isVisit[y][x])
			return;
		isVisit[y][x] = true;

		for (int i = 0; i < 4; i++) {
			// nextX, nextY
			int nx = x + dx[i], ny = y + dy[i];
			// 배열을 벗어난다던가 이미 방문 했다면 continue;
			if (!isBound(nx, ny) || isVisit[ny][nx])
				continue;
			// map이라면?
			if (map[ny][nx])
				dfs(nx, ny);
			else {
				//경계 값이므로 +1
				ans += 1;
			}
		}
	}

	// 배열 바운드 안에 들어있는지 확인하는 함수
	private static boolean isBound(int nx, int ny) {
		if (nx < 0 || nx > 101 || ny < 0 || ny > 101)
			return false;
		return true;
	}

	// map생성 함수
	private static void createMap(int c, int r) {
		for (int a = r; a < r + 10; a++) {
			for (int b = c; b < c + 10; b++) {
				map[a][b] = true;
			}
		}
	}
}
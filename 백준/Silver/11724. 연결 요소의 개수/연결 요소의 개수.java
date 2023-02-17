import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] isVisited = new boolean[N + 1];

		LinkedList<Integer>[] map = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			map[u].add(v);
			map[v].add(u);
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (isVisited[i])
				continue;
			bfs(map, isVisited, i);
			cnt += 1;
		}
		System.out.println(cnt);
	}

	private static void bfs(LinkedList<Integer>[] map, boolean[] isVisited, int s) {
		Queue<Integer> q = new LinkedList<>();
		isVisited[s] = true;
		q.add(s);

		while (!q.isEmpty()) {
			int v = q.poll();

			for (int np : map[v]) {
				if (isVisited[np])
					continue;
				isVisited[np] = true;
				q.add(np);
			}
		}
	}
}
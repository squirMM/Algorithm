import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
	static List<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int t = 1; t <= T; t++) {
			adjList = new ArrayList[101];
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (adjList[from] == null)
					adjList[from] = new ArrayList<>();
				adjList[from].add(to);
			}
			int ans = bfs(start, new boolean[101]);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int start, boolean[] isVisit) {
		Integer[] max = new Integer[] { 0, start };

		Queue<Integer[]> q = new ArrayDeque<>();
		isVisit[start] = true;
		q.offer(new Integer[] { 0, start });

		while (!q.isEmpty()) {
			Integer[] poll = q.poll();

			if (max[0] < poll[0]) {
				max = poll;
			} else if (max[0] == poll[0] && max[1] < poll[1])
				max[1] = poll[1];

			if (adjList[poll[1]] == null)
				continue;
			for (int num : adjList[poll[1]]) {
				if (isVisit[num])
					continue;
				isVisit[num] = true;
				q.offer(new Integer[] { poll[0] + 1, num });
			}

		}
		return max[1];
	}
}

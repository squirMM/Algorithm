import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
	List<Integer>[] adjList;

	public int solution(int n, int[][] edge)  {
		adjList = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int[] e : edge) {
			adjList[e[0]].add(e[1]);
			adjList[e[1]].add(e[0]);
		}
		int[] cnts = bfs(new boolean[n + 1], n);
		for (int i = cnts.length - 1; i >= 0; i--) {
			if (cnts[i] == 0)
				continue;
			return cnts[i];
		}
		return -1;
	}

	public int[] bfs(boolean[] isVisit, int n) {
		int[] cntList = new int[n + 1];
		Queue<Integer[]> q = new ArrayDeque<>();
		isVisit[1] = true;
		q.add(new Integer[] { 1, 0 });
		while (!q.isEmpty()) {
			Integer[] poll = q.poll();

			cntList[poll[1]] += 1;

			if (adjList[poll[0]] == null)
				continue;
			for (int next : adjList[poll[0]]) {
				if (isVisit[next])
					continue;
				isVisit[next] = true;
				q.add(new Integer[] { next, poll[1] + 1 });
			}
		}
		return cntList;
	}
}
class Solution {
	boolean[] isVisit;

	public int solution(int n, int[][] computers) {
		isVisit = new boolean[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (isVisit[i])continue;
			dfs(n, computers, i);
			ans+=1;
		}
		return ans;
	}

	private void dfs(int n, int[][] computers, int node) {

		for (int i = 0; i < n; i++) {
			if (node == i)
				continue;
			if (isVisit[i] || computers[node][i] == 0)
				continue;
			isVisit[i] = true;
			dfs(n, computers, i);
		}
		return;
	}
}
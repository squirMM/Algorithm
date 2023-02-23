import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int ans = bfs(N, K, new boolean[K + 1]);
		System.out.println(ans);
	}

	private static int bfs(int n, int k, boolean[] isVisit) {
		int ans = 100_000;
		ArrayDeque<int[]> q = new ArrayDeque<>();

		q.add(new int[] { n, 0 });
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			if (poll[0] >= k) {
				ans = Math.min(ans, poll[1] + Math.abs(k - poll[0]));
				continue;
			}
			if(poll[0]<0 || isVisit[poll[0]])
				continue;
			isVisit[poll[0]]=true;
			q.add(new int[] { poll[0] * 2, poll[1] + 1 });
			q.add(new int[] { poll[0] + 1, poll[1] + 1 });
			q.add(new int[] { poll[0] - 1, poll[1] + 1 });

		}
		return ans;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] asList;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken().trim());
		int M = Integer.parseInt(st.nextToken().trim());
		int V = Integer.parseInt(st.nextToken().trim());

		asList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			asList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			asList[a].add(b);
			asList[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(asList[i]);
		}

		boolean[] isVisit = new boolean[N + 1];
		isVisit[V] = true;
		
		dfs(V, isVisit);
		sb.append("\n");

		bfs(V, new boolean[N + 1]);
		System.out.println(sb);
	}

	private static void bfs(int s, boolean[] isVisit) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(s);

		isVisit[s] = true;
		while (!q.isEmpty()) {
			int v = q.poll();
			sb.append(v).append(" ");
			
			for (int i = 0; i < asList[v].size(); i++) {
				if (isVisit[asList[v].get(i)])
					continue;
				isVisit[asList[v].get(i)] = true;
				q.add(asList[v].get(i));
			}
		}
	}

	private static void dfs(int s, boolean[] isVisit) {
		sb.append(s).append(" ");
		for (int i = 0; i < asList[s].size(); i++) {
			if (isVisit[asList[s].get(i)])
				continue;
			isVisit[asList[s].get(i)] = true;
			dfs(asList[s].get(i), isVisit);
		}
		return;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<int[]>[] map;
	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		map = new ArrayList[V + 1];
		int start = Integer.parseInt(in.readLine());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (map[s] == null)
				map[s] = new ArrayList<>();
			map[s].add(new int[] { e, w });
		}

		StringBuilder sb = new StringBuilder();

		int[] dijkstra = dijkstra(start);
		for (int i = 1; i <= V; i++) {
			String ans = dijkstra[i] == Integer.MAX_VALUE ? "INF" : dijkstra[i] + "";
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static int[] dijkstra(int start) {
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		pq.add(new Integer[] { start, 0 });
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Integer[] poll = pq.poll();

			if (dist[poll[0]] < poll[1])
				continue;
			if (map[poll[0]] == null)
				continue;
			for (int i = 0; i < map[poll[0]].size(); i++) {
				int nv = map[poll[0]].get(i)[0], nw = map[poll[0]].get(i)[1];
				if (dist[nv] > poll[1] + nw) {
					dist[nv] = poll[1] + nw;
					pq.add(new Integer[] { nv, dist[nv] });
				}
			}

		}
		return dist;
	}
}
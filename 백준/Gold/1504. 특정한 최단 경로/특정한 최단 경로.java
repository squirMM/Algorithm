import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static List<int[]>[] map;
    static int N;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new int[]{b, c});
            map[b].add(new int[]{a, c});
        }
        st = new StringTokenizer(in.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int case1 = dijkstra(1, u) + dijkstra(u, v) + dijkstra(v, N);
        int case2 = dijkstra(1, v) + dijkstra(v, u) + dijkstra(u, N);
        if (case1 >= INF && case2 >= INF)
            System.out.println(-1);
        else System.out.println(Math.min(case1, case2));
    }

    private static int dijkstra(int s, int e) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{s, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            if (poll[0] == e)
                return poll[1];
            if (dist[poll[0]] < poll[1])
                continue;

            for (int i = 0; i < map[poll[0]].size(); i++) {
                int nxt = map[poll[0]].get(i)[0], nv = map[poll[0]].get(i)[1];
                if (dist[nxt] > poll[1] + nv) {
                    dist[nxt] = poll[1] + nv;
                    pq.add(new int[]{nxt, dist[nxt]});
                }
            }
        }
        return INF;
    }
}
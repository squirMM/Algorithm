import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, INF = 100_000_000;
    static List<int[]>[] map;
    static int[] route;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        m = Integer.parseInt(in.readLine());

        map = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[a].add(new int[]{b, v});
        }
        StringTokenizer st = new StringTokenizer(in.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        route = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        int value = dijkstra(s, e);
        sb.append(value).append("\n");
        Stack<Integer> stack = new Stack<>();
        int idx = e;
        while(idx!=0){
            stack.push(idx);
            idx = route[idx];
        }
        sb.append(stack.size()).append("\n");
        while (!stack.empty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    private static int dijkstra(int s, int e) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        pq.add(new int[]{s, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            if (poll[0] == e)
                return poll[1];

            if (dist[poll[0]] < poll[1])
                continue;

            for (int[] nxt : map[poll[0]]) {
                if(dist[nxt[0]]>poll[1]+nxt[1]){
                    dist[nxt[0]] = poll[1]+nxt[1];
                    pq.add(new int[]{nxt[0],dist[nxt[0]]});
                    route[nxt[0]] =  poll[0];
                }
            }
        }
        return INF;
    }
}
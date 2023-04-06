import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, INF = 100_000_0000;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int times = 1;
        while (true) {
            N = Integer.parseInt(in.readLine());
            if (N == 0) break;
            map = new int[N][N];
            for (int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            int ret = dijkstra();
            sb.append("Problem ").append(times++).append(": ").append(ret).append("\n");
        }
        System.out.println(sb);
    }

    private static int dijkstra() {
        int[][] dist = new int[N][N];
        for (int[] ints : dist) Arrays.fill(ints, INF);
        dist[0][0] = map[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.add(new int[]{0, 0, map[0][0]});

        int[] dy = {1, -1, 0, 0}, dx = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            if (poll[0] == N - 1 && poll[1] == N - 1)
                return poll[2];
            if (dist[poll[0]][poll[1]] < poll[2])
                continue;
            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i], nx = poll[1] + dx[i];
                if (!isBound(ny, nx)) continue;
                if (dist[ny][nx] > poll[2] + map[ny][nx]) {
                    dist[ny][nx] = poll[2] + map[ny][nx];
                    pq.add(new int[]{ny, nx, dist[ny][nx]});
                }
            }
        }
        return -1;
    }

    private static boolean isBound(int ny, int nx) {
        if (ny < 0 || ny >= N || nx < 0 || nx >= N)
            return false;
        return true;
    }
}
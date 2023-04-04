import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, ret = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(ret);
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1});
        int[] dy = {0, 1, 1}, dx = {1, 0, 1};
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (poll[1] == N - 1 && poll[2] == N - 1) {
                ret += 1;
                continue;
            }
            for (int i = 0; i < 3; i++) {
                if (poll[0] != 2 && poll[0] + i == 1) continue;
                int ny = poll[1] + dy[i], nx = poll[2] + dx[i];
                if (!isBound(ny, nx) || map[ny][nx] == 1) continue;
                if (i == 2 && (map[ny - 1][nx] == 1 || map[ny][nx - 1] == 1))
                    continue;
                q.add(new int[]{i, ny, nx});
            }
        }
    }

    private static boolean isBound(int ny, int nx) {
        return ny >= 0 && ny < N && nx >= 0 && nx < N;
    }
}
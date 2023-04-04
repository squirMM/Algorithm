import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int ret = -1, H, W;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ret = bfs(K, H, W);
        System.out.println(ret);
    }

    private static int bfs(int k, int h, int w) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0, 0});
        boolean[][][] visit = new boolean[h][w][k+1];
        visit[0][0][0] = true;
        int[] mdy = {0, 0, -1, 1}, mdx = {1, -1, 0, 0}, hdy = {2, 1, -2, -1, 2, 1, -2, -1}, hdx = {1, 2, 1, 2, -1, -2, -1, -2};

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (poll[0] == h - 1 && poll[1] == w - 1) {
                return poll[3];
            }
            for (int mIdx = 0; mIdx < mdy.length; mIdx++) {
                int ny = poll[0] + mdy[mIdx], nx = poll[1] + mdx[mIdx];
                if (!isBound(ny, nx) || map[ny][nx] == 1 || visit[ny][nx][poll[2]]) continue;
                visit[ny][nx][poll[2]] = true;
                q.add(new int[]{ny, nx, poll[2], poll[3] + 1});
            }
            if (poll[2] < k) {
                for (int hIdx = 0; hIdx < hdy.length; hIdx++) {
                    int ny = poll[0] + hdy[hIdx], nx = poll[1] + hdx[hIdx];
                    if (!isBound(ny, nx) || map[ny][nx] == 1 || visit[ny][nx][poll[2]+1]) continue;
                    visit[ny][nx][poll[2]+1] = true;
                    q.add(new int[]{ny, nx, poll[2]+1, poll[3] + 1});
                }
            }
        }
        return -1;
    }

    private static boolean isBound(int ny, int nx) {
        return ny >= 0 && ny < H && nx >= 0 && nx < W;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main {
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            String line = in.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = line.charAt(c) - '0';
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 1) {
                    ans.add(bfs(r, c));
                    cnt+=1;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(ans);
        for (int a : ans)
            System.out.println(a);
    }

    private static Integer bfs(int r, int c) {
        int cnt = 1;
        int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
        Queue<int[]> q = new ArrayDeque<>();
        map[r][c] = -1;
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = poll[0] + dr[i], nc = poll[1] + dc[i];
                if (!isBound(nr, nc)) continue;
                if (map[nr][nc] == 1) {
                    map[nr][nc] = -1;
                    q.add(new int[]{nr, nc});
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    private static boolean isBound(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N)
            return false;
        return true;
    }
}
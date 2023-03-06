import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Solution
 {
    static int[][] map;
    static int N, W, H, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            ans = Integer.MAX_VALUE;
            for (int r = 0; r < H; r++) {
                st = new StringTokenizer(in.readLine());
                for (int c = 0; c < W; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            permutation(0, copyMap(map));
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void permutation(int cnt, int[][] cloneMap) {
        if (cnt == N) {
            checkMap(cloneMap);
            return;
        }
        for (int i = 0; i < W; i++) {
            int[][] tmp = copyMap(cloneMap);
            permutation(cnt + 1, playGame(i, tmp));
        }
    }

    private static void checkMap(int[][] map) {
        int cnt = 0;
        for (int c = 0; c < W; c++) {
            for (int r = H - 1; r >=0; r--) {
                if (map[r][c] == 0) {
                    cnt += H - r - 1;
                    break;
                }
            }
            if (map[0][c] == 1)
                cnt += H;
        }
        ans = Math.min(ans, cnt);
    }

    private static int[][] playGame(int s, int[][] cloneMap) {
        for (int i = 0; i < H; i++) {
            if (cloneMap[i][s] != 0) {
                boolean need = bfs(i, s, cloneMap);
                if (need) cloneMap = organizeMap(cloneMap);
                break;
            }
        }
        return cloneMap;
    }

    private static int[][] organizeMap(int[][] cloneMap) {
        int[][] organizeMap = new int[H][W];
        for (int c = 0; c < W; c++) {
            List<Integer> list = new ArrayList<>();
            for (int r = 0; r < H; r++) {
                if (cloneMap[r][c] != 0) list.add(cloneMap[r][c]);
            }
            int idx = list.size() - 1;
            for (int r = H - 1; r > H - 1 - list.size(); r--) {
                organizeMap[r][c] = list.get(idx--);
            }
        }
        return organizeMap;
    }

    private static boolean bfs(int r, int c, int[][] cloneMap) {
        int[] dr = {1, -1, 0, 0}, dc = {0, 0, -1, 1};
        ArrayDeque<Integer[]> q = new ArrayDeque<>();

        q.add(new Integer[]{r, c, cloneMap[r][c] - 1});
        cloneMap[r][c] = 0;

        boolean needOrganize = false;
        while (!q.isEmpty()) {
            Integer[] poll = q.poll();

            if (poll[2] == 0)
                continue;

            for (int ran = 1; ran <= poll[2]; ran++) {
                for (int i = 0; i < 4; i++) {
                    int nr = poll[0] + ran * dr[i], nc = poll[1] + ran * dc[i];
                    if (!isBound(nr, nc))
                        continue;

                    needOrganize = true;
                    if (cloneMap[nr][nc] > 1)
                        q.add(new Integer[]{nr, nc, cloneMap[nr][nc] - 1});
                    cloneMap[nr][nc] = 0;
                }
            }
        }
        return needOrganize;
    }

    private static boolean isBound(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < H && nc < W;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] tmp = new int[H][W];
        for (int i = 0; i < H; i++)
            tmp[i] = map[i].clone();
        return tmp;
    }
}
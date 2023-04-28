import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] one = {3, 0, 1, 2}, five = {0, 1, 2, 3},
            dy = {-1, 1, 0, 0,}, dx = {0, 0, -1, 1};
    static int[][] two = {{2, 3}, {0, 1}}, thr = {{1, 3}, {3, 0}, {0, 2}, {1, 2}},
            four = {{1, 2, 3}, {1, 3, 0}, {3, 0, 2}, {0, 2, 1}};
    static List<cctv> cctvs;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        cctvs = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] != 0 && map[r][c] != 6)
                    cctvs.add(new cctv(r, c, map[r][c]));
            }
        }
        perm(0, map, cctvs.size());
        System.out.println(ret);
    }

    private static void perm(int depth, int[][] map, int r) {
        if (depth == r) {
            ret = Math.min(ret, blindSpot(map));
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[][] copy = copyArr(map);
            direction(copy, cctvs.get(depth), i);
            perm(depth + 1, copy, r);

        }
    }

    private static int blindSpot(int[][] map) {
        int cnt = 0;
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (map[r][c] == 0) cnt += 1;
            }
        }
        return cnt;
    }

    private static void direction(int[][] map, cctv cctv, int i) {
        if (cctv.idx == 1) {
            watch(map, cctv.r, cctv.c, one[i]);
        } else if (cctv.idx == 2) {
            watch(map, cctv.r, cctv.c, two[i % 2][0]);
            watch(map, cctv.r, cctv.c, two[i % 2][1]);
        } else if (cctv.idx == 3) {
            watch(map, cctv.r, cctv.c, thr[i][0]);
            watch(map, cctv.r, cctv.c, thr[i][1]);
        } else if (cctv.idx == 4) {
            watch(map, cctv.r, cctv.c, four[i][0]);
            watch(map, cctv.r, cctv.c, four[i][1]);
            watch(map, cctv.r, cctv.c, four[i][2]);
        } else if (cctv.idx == 5) {
            watch(map, cctv.r, cctv.c, 0);
            watch(map, cctv.r, cctv.c, 1);
            watch(map, cctv.r, cctv.c, 2);
            watch(map, cctv.r, cctv.c, 3);
        }
    }

    private static void watch(int[][] map, int r, int c, int i) {
        while (true) {
            int ny = r + dy[i], nx = c + dx[i];
            if (ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length) break;
            if (map[ny][nx] == 6) break;
            map[ny][nx] = -1;
            r = ny;
            c = nx;
        }
    }

    private static int[][] copyArr(int[][] map) {
        int[][] clone = new int[map.length][map[0].length];
        for (int r = 0; r < map.length; r++)
            clone[r] = map[r].clone();
        return clone;
    }

    static class cctv {
        int r, c, idx;

        public cctv(int r, int c, int idx) {
            this.r = r;
            this.c = c;
            this.idx = idx;
        }
    }
}
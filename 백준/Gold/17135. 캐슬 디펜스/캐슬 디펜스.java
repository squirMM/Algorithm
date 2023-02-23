import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M, D, c_idx = 0, ans = 0;
    static int[][] map;
    static List<int[]> combi = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        makeCombi(0, 0, new int[3]);

        for (int[] com : combi) {
            playGame(com, copyArray(map));
        }

        System.out.println(ans);
    }

    private static int[][] copyArray(int[][] map) {
        int[][] arr = new int[N][M];
        for (int idx = 0; idx < map.length; idx++) {
            arr[idx] = map[idx].clone();
        }
        return arr;
    }

    private static void playGame(int[] com, int[][] m) {
        int times = N, total = 0;
//        System.out.println("combi: " + Arrays.toString(com));
        ArrayList<int[]> list = new ArrayList<>();
        while (times-- > 0) {
            for (int c : com) {
                list.add(bfs(c, m, times));
            }
            for (int[] p : list) {
//                System.out.println(Arrays.toString(p));
                if (!isBound(p[0], p[1]) || m[p[0]][p[1]] == 0) continue;
                total += 1;
                m[p[0]][p[1]] = 0;
            }
//            System.out.print(total + " ");
        }
//        System.out.println();
        ans = Math.max(total, ans);
    }

    private static int[] bfs(int c, int[][] m, int times) {
        int[] dx = {-1, 0, 1}, dy = {0, -1, 0};

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{times, c, 1});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (m[poll[0]][poll[1]] == 1) {
                return poll;
            }
            for (int i = 0; i < 3; i++) {
                int ny = poll[0] + dy[i], nx = poll[1] + dx[i];
                if (!isBound(ny, nx) || poll[2] + 1 > D) continue;
                q.add(new int[]{ny, nx, poll[2] + 1});
            }
        }
        return new int[]{-1, -1};
    }

    private static boolean isBound(int ny, int nx) {
        if (ny < 0 || ny >= N || nx < 0 || nx >= M) return false;
        return true;
    }

    private static void makeCombi(int start, int cnt, int[] selected) {
        if (cnt == 3) {
            combi.add(selected.clone());
            return;
        }
        for (int i = start; i < M; i++) {
            selected[cnt] = i;
            makeCombi(i + 1, cnt + 1, selected);
        }
    }
}
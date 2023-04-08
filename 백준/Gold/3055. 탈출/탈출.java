import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Position {
        int y, x, t;

        public Position(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }
    }

    static int[][] ch, wch;
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Queue<Position> wq = new ArrayDeque<>();
        Position sp = null, ep = null;
        ch = new int[R][C];
        wch = new int[R][C];
        for (int[] ints : wch) Arrays.fill(ints, Integer.MAX_VALUE);
        for (int r = 0; r < R; r++) {
            String s = in.readLine();
            for (int c = 0; c < C; c++) {
                if (s.charAt(c) == 'S') sp = new Position(r, c, 0);
                if (s.charAt(c) == 'D') ep = new Position(r, c, 0);
                if (s.charAt(c) == 'X') ch[r][c] = -1;
                if (s.charAt(c) == '*') {
                    wch[r][c] = 0;
                    wq.add(new Position(r, c, 0));
                }
            }
        }
        int ret = bfs(sp, ep, wq);
        System.out.println(ret == Integer.MAX_VALUE ? "KAKTUS" : ret);
    }

    private static int bfs(Position sp, Position ep, Queue<Position> wq) {
        Queue<Position> q = new ArrayDeque<>();
        q.add(sp);

        int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};

        int times = Integer.MAX_VALUE;

        while (!wq.isEmpty()) {
            Position wp = wq.poll();
            for (int i = 0; i < 4; i++) {
                int ny = wp.y + dy[i], nx = wp.x + dx[i];
                if (ny == ep.y && nx == ep.x) continue;
                if (!isBound(ny, nx) || ch[ny][nx] == -1 || wch[ny][nx] != Integer.MAX_VALUE) continue;
                wch[ny][nx] = wp.t + 1;
                Position nwp = new Position(ny, nx, wch[ny][nx]);
                wq.add(nwp);
            }
        }

        ch[sp.y][sp.x] = 1;
        while (!q.isEmpty()) {
            Position np = q.poll();
            if (np.y == ep.y && np.x == ep.x) {
                times = Math.min(times, np.t);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = np.y + dy[i], nx = np.x + dx[i];
                if (!isBound(ny, nx) || ch[ny][nx] != 0 ||  wch[ny][nx] <= np.t+1) continue;
                ch[ny][nx] = 1;
                Position nnp = new Position(ny, nx, np.t + 1);
                q.add(nnp);
            }
        }
        return times;
    }

    private static boolean isBound(int ny, int nx) {
        if (ny < 0 || ny >= R || nx < 0 || nx >= C)
            return false;
        return true;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static char[][] map;
    static int ret = 0;

    public static void main(String[] args) throws IOException {
//		맨 밑 바닥부터 탐색
//		색이 하나 발견 되었다면 이를 기준으로 터트림
//		터뜨린 다음에 바닥부터 탐색하여 다시 찾음
//		위 과정 반복
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for (int r = 0; r < 12; r++) {
            char[] c = in.readLine().toCharArray();
            map[r] = c.clone();
        }

        while (play()) {
            for (int c = 0; c < 6; c++) {
                Queue<Character> q = new ArrayDeque<>();
                for (int r = 11; r >= 0; r--) {
                    if (map[r][c] != '.') {
                        q.add(map[r][c]);
                        map[r][c] = '.';
                    }
                }
                int r = 11;
                while (!q.isEmpty() && r >= 0) {
                    if (map[r][c] == '.')
                        map[r][c] = q.poll();
                    r--;
                }
            }
        }
        System.out.println(ret);
    }

    private static void printArr() {
        for (int r = 0; r < 12; r++) {
            System.out.println(Arrays.toString(map[r]));
        }
    }

    private static boolean play() {
        boolean flag = false;
        for (int c = 0; c < 6; c++) {
            for (int r = 11; r >= 0; r--) {
                if(map[r][c] == '.') continue;
                boolean tag = bfs(r, c, map[r][c]);
                flag = flag||tag;
            }
        }
        if (flag) ret += 1;
        return flag;
    }

    private static boolean bfs(int y, int x, char c) {
        char[][] copy = new char[12][6];
        for (int r = 0; r < 12; r++) {
            copy[r] = map[r].clone();
        }

        int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
        int cnt = 1;
        Queue<int[]> q = new ArrayDeque<int[]>();
        q.add(new int[]{y, x});
        copy[y][x] = '.';

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i], nx = poll[1] + dx[i];
                if (!isBound(ny, nx) || copy[ny][nx] != c)
                    continue;
                copy[ny][nx] = '.';
                cnt += 1;
                q.add(new int[]{ny, nx});
            }
        }

        if (cnt >= 4) {
//			BOMB!!
            for (int r = 0; r < 12; r++)
                map[r] = copy[r].clone();
            return true;
        }
        return false;
    }

    private static boolean isBound(int ny, int nx) {
        if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6)
            return false;
        return true;
    }

}
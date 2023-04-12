import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] map;
    static int N, cnt;
    static boolean[] ch;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
        }

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            ch = new boolean[N + 1];
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++)
            max = Math.max(max, arr[i]);
//        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (max == arr[i])
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs(int i) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        ch[i] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int nxt : map[poll]) {
                if (!ch[nxt]) {
                    ch[nxt] = true;
                    arr[nxt]++;
                    q.add(nxt);
                }
            }
        }
    }
}
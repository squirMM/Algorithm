import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, d, k, c;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        int[] nums = new int[d + 1];
        nums[c] = 1;
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(in.readLine());
            if (i < k) {
                if (nums[n]++ == 0) cnt += 1;
            }
            list.add(n);
        }

        int s = 0, e = k - 1, ret = cnt;
        do {
            if (--nums[list.get(s)] == 0) cnt -= 1;
            s = s + 1 == list.size() ? 0 : s + 1;
            e = e + 1 == list.size() ? 0 : e + 1;
            if (nums[list.get(e)]++ == 0) cnt += 1;
            ret = Math.max(cnt, ret);
        } while (s != 0 && e != k - 1);

        System.out.println(ret);
    }
}
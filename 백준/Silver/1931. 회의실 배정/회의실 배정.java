import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");

            int sT = Integer.parseInt(st.nextToken());
            int eT = Integer.parseInt(st.nextToken());
            int[] times = {sT, eT};
            arr[i] = times;
        }
        Arrays.sort(arr, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[1];
            } else {
                return o1[1] - o2[1];
            }
        }));

        int ans = 1;
        int prev = arr[0][1];
        for (int i = 1; i < N; i++) {
            if (arr[i][0] >= prev) {
                ans += 1;
                prev = arr[i][1];
            }
        }
        System.out.println(ans);
    }
}
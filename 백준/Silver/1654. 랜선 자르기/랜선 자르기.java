import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K, N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[K];
		long max = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(in.readLine().trim());
			max = Math.max(max, arr[i]);
		}

		long ans = binarySearch(0, max + 1);

		System.out.println(ans);
	}

	private static long binarySearch(long low, long high) {
		while (low < high) {
			long mid = (long) (low + high) / 2;
			long cnt = 0;
			for (int a : arr) {
				cnt += (int) a / mid;
			}
			if (cnt < N)
				high = mid;
			else {
				low = mid + 1;
			}
		}
		return high - 1;
	}
}
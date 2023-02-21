import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		long max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		long totalMax = Integer.parseInt(in.readLine());

		long ans = upperBinarySearch(totalMax, 0, max + 1);
		System.out.println(ans);
	}

	private static long upperBinarySearch(long tMax, long low, long high) {
		while (low < high) {
			long mid = (low + high) / 2;
			long sum = calSum(mid);
			if (sum > tMax) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return high - 1;
	}

	private static long calSum(long size) {
		long sum = 0;
		for (int a : arr) {
			if (a < size)
				sum += a;
			else {
				sum += size;
			}
		}
		return sum;
	}
}
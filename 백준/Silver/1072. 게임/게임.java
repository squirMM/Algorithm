import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Long X, Y;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());

		long ans = lowerBinarySearch(0, X + 1, (int) ((double) Y * 100 / (double) X));
		System.out.println(ans);
	}

	private static long lowerBinarySearch(long low, long high, int per) {
		while (low < high) {
			long mid = (low + high) / 2;
			int p = (int) ((double) (Y + mid) * 100 / (double) (X + mid));
			if (p > per) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return high > X ? -1 : high;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		long max = 0, sum = 0;
		for (int idx = 0; idx < N; idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[idx]);
			sum += arr[idx];
		}
		if (M == 1)
			System.out.println(sum);
		else {
			System.out.println(binarySearch(max, sum+1));
		}
	}

	private static long binarySearch(long low, long high) {
		while (low < high) {
			long mid = (low + high) / 2;
			long sum = 0, cnt = 0;
			for (int a : arr) {
				if (sum + a > mid) {
//					System.out.println(sum);
					cnt += 1; sum = 0;
				}
				sum += a;
			}
			if(sum!=0) cnt+=1;
//			System.out.println(mid+" "+cnt);
			if (cnt > M)
				low = mid+1;
			else
				high = mid;
		}
//		System.out.println(high);
		return high;
	}
}
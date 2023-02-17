import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int ans = 1_000_000_000, N;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[i][0] = a;
			arr[i][1] = b;

			// 음식을 하나만 사용한 경우
			ans = Math.min(Math.abs(a - b), ans);
		}
		// 음식을 여러종류 사용한 경우
		for (int i = 2; i <= N; i++) {
			int[] selected =new int[N];
			Arrays.fill(selected, -1);
			bf(i, 0, selected, 0);
		}
		System.out.println(ans);
	}

	private static void bf(int i, int cnt, int[] selected, int start) {
		// TODO Auto-generated method stub
		if (cnt == i) {
			ans = Math.min(ans, calculate(selected));
			return;
		}
		for (int s = start; s < N; s++) {
			selected[cnt] = s;
			bf(i, cnt + 1, selected, s + 1);
		}
	}

	private static int calculate(int[] isSelected) {
		int sum = 0, mul = 1;
		for (int idx : isSelected) {
			if(idx==-1)continue;
			mul *= arr[idx][0];
			sum += arr[idx][1];
		}
		return Math.abs(sum - mul);
	}
	
	
}
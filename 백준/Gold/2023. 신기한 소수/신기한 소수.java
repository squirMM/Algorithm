import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		int[] arr = { 2, 3, 5, 7 };
		for (int a : arr) {
			makeNum(N, 1, a);
		}

		System.out.println(sb.toString());
	}

	public static boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void makeNum(int N, int cnt, int num) {
		if (cnt == N) {
			sb.append(num).append("\n");
			return;
		}
		for (int i = 1; i <= 9; i += 2) {
			if (!isPrime(num * 10 + i))
				continue;
			makeNum(N, cnt + 1, num * 10 + i);
		}
	}
}
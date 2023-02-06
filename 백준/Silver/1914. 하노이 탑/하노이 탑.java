import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());

		BigInteger bi = new BigInteger("2");
		BigInteger c = bi.pow(num).subtract(BigInteger.ONE);
		System.out.println(c);
		if (num <= 20) {
			hanoi(num, 1, 3, 2);
		}
	}

	public static void hanoi(int N, int start, int end, int sub) {
		if (N == 1) {
			System.out.println(start + " " + end);
			return;
		} else {
			hanoi(N - 1, start, sub, end);
			System.out.println(start + " " + end);
			hanoi(N - 1, sub, end, start);
		}
	}
}
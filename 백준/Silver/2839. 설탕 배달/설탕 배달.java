import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		int ans = -1;
		for (int f = (int) N / 5; f >= 0; f--) {
			int a = N - 5*f;
			if(a%3 == 0) {
				ans = f + (int)a/3;
				break;
			}
		}
		System.out.println(ans);
	}
}
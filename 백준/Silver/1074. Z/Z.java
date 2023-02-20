import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c, ans;
	static int x,y;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		ans = 0;
		x=0; y=0;
		recur(N, 0);

		System.out.println(ans);
	}

	private static void recur(int n, int base) {
		if (n == -1) {
			ans = base;
			return;
		}
		int box = (int) ((int) Math.pow(2, n - 1) * Math.pow(2, n - 1));
		int nb = bound(n - 1);
		recur(n - 1, base + nb * box);
	}

	private static int bound(int n) {
		int mid = (int) Math.pow(2, n);
		int max = (int) Math.pow(2, n + 1);
		if (c >= x && c < x + mid && r >= y && r < y + mid) {
			return 0;
		}
		else if (c >= x + mid && c < x + max && r >= y && r < y + mid) {
			x+=mid;
			return 1;
		}
		else if (c >= x && c < x + mid && r >= y + mid && r < y + max) {
			y+=mid;
			return 2;
		}
		x+=mid; y+=mid;
		return 3;
	}
}
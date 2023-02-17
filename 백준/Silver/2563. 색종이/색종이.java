import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		boolean[][] isCheck = new boolean[101][101];
		int ans = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int r = y; r < y + 10; r++) {
				for (int c = x; c < x + 10; c++) {
					if (isCheck[r][c])
						continue;
					isCheck[r][c] = true;
					ans += 1;
				}
			}
		}

		System.out.println(ans);

	}
}
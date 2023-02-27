import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder(); 
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		arr = new int[N][N];
		for (int r = 0; r < N; r++) {
			String rl = in.readLine();
			for (int c = 0; c < N; c++) {
				arr[r][c] = rl.charAt(c)-'0';
			}
		}
		dc(0, 0, N);
		System.out.println(sb);
	}

	private static void dc(int r, int c, int len) {
		int compressable = compressable(r, c, len);
		if (compressable != -1) {
			sb.append(compressable);
			return;
		}
		sb.append("(");
		dc(r, c, len / 2);
		dc(r, c + len / 2, len / 2);
		dc(r + len / 2, c, len / 2);
		dc(r + len / 2, c + len / 2, len / 2);
		sb.append(")");
	}

	private static int compressable(int r, int c, int len) {
		int z_cnt = 0, o_cnt = 0;
		for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {
				if (arr[i][j] == 0) z_cnt++;
				if (arr[i][j] == 1) o_cnt++;
				if (z_cnt > 0 && o_cnt > 0) return -1;
			}
		}
		if (z_cnt > 0)
			return 0;
		return 1;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n + 2][n + 2];
		for (int r = 1; r <= n; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 1; c <= n; c++) {
				arr[r][c] = arr[r][c - 1] + arr[r - 1][c] -arr[r-1][c-1] + Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int ans = arr[x2][y2] - arr[x2][y1-1] -arr[x1-1][y2] +arr[x1-1][y1-1];
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
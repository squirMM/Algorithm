import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String s = in.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		sb = new StringBuilder();
		dfs(0, 0);
		
	}

	private static void dfs(int i, int j) {
		if (i == 9) {
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr[0].length; c++) {
					sb.append(arr[r][c]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		if (arr[i][j] == 0) {
			for (int n = 1; n <= 9; n++) {
				if (isAlready(i, j, n))
					continue;
				arr[i][j] = n;
				if (j + 1 == 9)
					dfs(i + 1, 0);
				else
					dfs(i, j + 1);
				arr[i][j] = 0;
			}
		} else {
			if (j + 1 == 9)
				dfs(i + 1, 0);
			else
				dfs(i, j + 1);
		}
		return;
	}

	private static boolean isAlready(int i, int j, int n) {
		for (int k = 0; k < 9; k++) {
			if (arr[k][j] == n || arr[i][k] == n)
				return true;
		}
		for (int idx = (int) (i / 3) * 3; idx < (int) (i / 3) * 3 + 3; idx++) {
			for (int jdx = (int) (j / 3) * 3; jdx < (int) (j / 3) * 3 + 3; jdx++) {
				if (arr[idx][jdx] == n)
					return true;
			}
		}
		return false;
	}

}
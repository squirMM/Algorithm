import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static String[] gather = { "a", "e", "i", "o", "u" }, arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new String[C];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken();
		}

		Arrays.sort(arr);
		dfs(0, 0, 0, 0, new StringBuilder());
		System.out.println(sb);
	}

	private static void dfs(int start, int cnt, int bits, int cg, StringBuilder pw) {
		if (cnt == L) {
			if (cg > 0 && L - cg > 1)
				sb.append(pw).append("\n");
			return;
		}
		for (int i = start; i < C; i++) {
			if ((bits & (1 << arr[i].charAt(0) - 'a')) != 0)
				continue;
			dfs(i + 1, cnt + 1, bits | (1 << arr[i].charAt(0) - 'a'),isGather(arr[i])?cg+1:cg, pw.append(arr[i]));
			pw.setLength(cnt);
		}
	}

	private static boolean isGather(String pw) {
		for (String g : gather) {
			if (pw.equals(g))
				return true;
		}
		return false;
	}
}
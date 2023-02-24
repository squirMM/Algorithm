import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static String[] arr;

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
		dfs(0, 0, new StringBuilder());
		System.out.println(sb);
	}

	private static void dfs(int start, int cg, StringBuilder pw) {
		if (pw.length() == L) {
			if (cg > 0 && L - cg > 1)
				sb.append(pw).append("\n");
			return;
		}
		for (int i = start; i < C; i++) {
			dfs(i + 1, isGather(arr[i]) ? cg + 1 : cg, pw.append(arr[i]));
			pw.deleteCharAt(pw.length() - 1);
		}
	}

	private static boolean isGather(String pw) {
		if (pw.equals("a") || pw.equals("e") || pw.equals("i") || pw.equals("o") || pw.equals("u"))
			return true;
		return false;
	}
}
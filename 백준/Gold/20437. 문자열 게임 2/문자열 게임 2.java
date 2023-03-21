import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			String W = in.readLine();
			int K = Integer.parseInt(in.readLine());
			if (K == 1) { // k가 1일때
				System.out.println("1 1");
				continue;
			}
			int min = Integer.MAX_VALUE, max = -1;

			int[] alpha = new int[26];
			for (int i = 0; i < W.length(); i++) {
				alpha[W.charAt(i) - 'a']++;
			}

			for (int i = 0; i < W.length(); i++) {
				if (alpha[W.charAt(i) - 'a'] < K)
					continue;

				int cnt = 1;
				for (int j = i + 1; j < W.length(); j++) {
					if (W.charAt(i) == W.charAt(j))
						cnt += 1;
					if (cnt == K) {
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1);
						break;
					}
				}
			}

			if (min == Integer.MAX_VALUE || max == -1) {
				System.out.println(-1);
			} else {
				System.out.println(min + " " + max);
			}
		}
	}
}
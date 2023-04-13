import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		StringBuilder ret = new StringBuilder();

		out: for (int t = 0; t < T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("[");

			char[] comm = in.readLine().toCharArray();
			
			int n = Integer.parseInt(in.readLine());
			String S = in.readLine();
			
			String[] split = null;
			if (n != 0 ) {
				S = S.substring(1, S.length() - 1);
				split = S.split(",");
			}else {
				split = new String[0];
			}
			
			int s = 0, e = split.length - 1;
			boolean isReverse = false;
			for (char c : comm) {
				if (c == 'D') {
					if (s > e) {
						ret.append("error").append("\n");
						continue out;
					}
					if (isReverse)
						e--;
					else
						s++;
				} else {
					isReverse = !isReverse;
				}

			}
			// 배열 내부의 값 저장
			if (isReverse && s<=e) {
				for (int i = e; i > s; i--)
					sb.append(Integer.parseInt(split[i])).append(",");
				sb.append(Integer.parseInt(split[s]));
			} else if(!isReverse && s<=e) {
				for (int i = s; i < e; i++)
					sb.append(Integer.parseInt(split[i])).append(",");
				sb.append(Integer.parseInt(split[e]));
			}
			sb.append("]").append("\n");
			ret.append(sb);
		}
		System.out.println(ret);
	}
}
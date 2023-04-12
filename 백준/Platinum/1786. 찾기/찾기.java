import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String T = in.readLine();
		String P = in.readLine();

		int tLen = T.length(), pLen = P.length();

//		부분 일치 테이블 만들기 
		int[] pi = new int[pLen];
		for (int i = 1, j = 0; i < pLen; i++) {
			while (j > 0 && P.charAt(i) != P.charAt(j))
				j = pi[j - 1];
			if (P.charAt(i) == P.charAt(j))
				pi[i] = ++j;
		}

		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
//		i = 텍스트 포인터, j = 패턴 포인터
		for (int i = 0, j = 0; i < tLen; i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j))
				j = pi[j - 1];

			if (T.charAt(i) == P.charAt(j)) {
				if (j == pLen - 1) {
					++cnt;
					list.add(i - j + 1);
					j = pi[j];
				} else
					j++;

			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for (Integer num : list)
			sb.append(num).append(" ");
		System.out.println(sb);
	}
}
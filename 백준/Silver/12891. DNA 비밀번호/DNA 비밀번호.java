import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int lenS = Integer.parseInt(st.nextToken());
		int lenP = Integer.parseInt(st.nextToken());

		String s = in.readLine();
//		a,c,g,t
		int[] isChecked = new int[4];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 4; i++) {
			int n = Integer.parseInt(st.nextToken());
			isChecked[i] = n;
		}

		int[] arr = new int[4];
		int start = 0, end = 0, ans = 0;
		arr[searchIdx(s.charAt(start))] += 1;
		
		while (end < lenS && end >= start) {
			if (end - start + 1 < lenP) {
				if (++end < lenS)
					arr[searchIdx(s.charAt(end))] += 1;
			}
			if (end - start + 1 == lenP) {
				if (isCorrect(isChecked, arr))
					ans += 1;

				arr[searchIdx(s.charAt(start++))] -= 1;
				if (++end < lenS)
					arr[searchIdx(s.charAt(end))] += 1;
			}
		}
		System.out.println(ans);
	}

	private static boolean isCorrect(int[] isChecked, int[] arr) {
		for (int i = 0; i < 4; i++) {
			if (isChecked[i] > arr[i])
				return false;
		}
		return true;
	}

	private static int searchIdx(char c) {
		if (c == 'A') {
			return 0;
		} else if (c == 'C') {
			return 1;
		} else if (c == 'G') {
			return 2;
		}
		return 3;
	}

}
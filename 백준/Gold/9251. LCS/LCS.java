import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String a = "0" + in.readLine();
		String b = "0" + in.readLine();

		int[][] lcs = new int[a.length()][b.length()];
		for (int i = 1; i < a.length(); i++) {
			for (int j = 1; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j))
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				else {
					lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
				}
			}
		}
		System.out.println(lcs[a.length()-1][b.length()-1]);
	}
}
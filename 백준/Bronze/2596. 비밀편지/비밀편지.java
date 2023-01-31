import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		String code = in.readLine();
		decode(num, code);
	}

	public static void decode(int num, String code) {
		String[] dic = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };
		String decodeAns = "";
		for (int idx = 0; idx < num; idx++) {
			String sub = code.substring(idx * 6, (idx + 1) * 6);
			boolean check = false;
			for (int i = 0; i < dic.length; i++) {
				// 비트 연산
				int n = (Integer.parseInt(dic[i], 2) ^ Integer.parseInt(sub, 2));
				// 비트 연산 2의 지수인지
				if ((n & (n - 1)) == 0) {
					decodeAns += (char) ((int) 'A' + i);
					check = true;
					break;
				}
			}
			if (!check) {
				System.out.println(idx + 1);
				return;
			}
		}
		System.out.println(decodeAns);
	}

}
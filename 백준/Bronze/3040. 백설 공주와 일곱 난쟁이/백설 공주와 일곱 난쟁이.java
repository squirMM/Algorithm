import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<int[]> per = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		StringBuilder sb = new StringBuilder();
		makePermutation(0, new int[7], new boolean[9]);
		for (int[] p : per) {
			int sum = 0;
			sb.setLength(0);
			for (int a : p) {
				sum += arr[a];
				sb.append(arr[a]).append("\n");
			}
			if(sum==100)
				break;
		}
		System.out.println(sb);
	}

	private static void makePermutation(int cnt, int[] selected, boolean[] isVisit) {
		if (cnt == 7) {
			per.add(selected.clone());
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (isVisit[i])continue;
			isVisit[i] = true;
			selected[cnt] = i;
			makePermutation(cnt + 1, selected, isVisit);
			isVisit[i] = false;
		}

	}
}
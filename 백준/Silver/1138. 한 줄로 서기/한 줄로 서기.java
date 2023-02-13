import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		List<Integer>[] list = new ArrayList[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (list[num] == null)
				list[num] = new ArrayList<Integer>();
			list[num].add(i + 1);
		}

		List<Integer> nums = new ArrayList<>();
		nums.addAll(list[0]);
		for (int i = 1; i < N; i++) {
			if (list[i] == null)
				continue;
			for (int idx = list[i].size()-1; idx >=0 ; idx--) {
				int cnt = 0, ni = 0;
				for (; ni < nums.size(); ni++) {
					if (nums.get(ni) > list[i].get(idx))
						cnt++;
					if (cnt == i)
						break;
				}
				nums.add(ni + 1, list[i].get(idx));
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.size(); i++) {
			sb.append(nums.get(i)).append(" ");
		}
		System.out.println(sb);
	}
}
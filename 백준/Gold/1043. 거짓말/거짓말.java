import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		List<Integer> p = new ArrayList<Integer>();
		for (int i = 0; i < K; i++) {
			p.add(Integer.parseInt(st.nextToken()));
		}

		List<List<Integer>> partyList = new ArrayList<>();
		for (int party = 0; party < M; party++) {
			st = new StringTokenizer(in.readLine(), " ");
			int pn = Integer.parseInt(st.nextToken());
			List<Integer> tmp = new ArrayList<>();
			for (int pp = 0; pp < pn; pp++) {
				tmp.add(Integer.parseInt(st.nextToken()));
			}
			partyList.add(tmp);
		}

		for (int i = 0; i < M; i++) {
			for (List<Integer> party : partyList) {
				List<Integer> targetList = new ArrayList<>(party);
				targetList.removeAll(p);
				if (targetList.size() != party.size()) {
					p.addAll(targetList);
				}
			}
		}

		int ans = 0;
		for (List<Integer> list : partyList) {
			int size = list.size();
			list.removeAll(p);
			if (size == list.size()) {
				ans += 1;
			}
		}
		System.out.println(ans);
	}
}

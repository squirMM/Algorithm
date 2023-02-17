import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<int[]>combi = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<int[]> home = new ArrayList<>();
		List<int[]> chicken = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < N; c++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 0) continue;
				else if(num == 1) home.add(new int[] {r,c});
				else if(num == 2) chicken.add(new int[] {r,c});
			}
		}
		makeCombination(M, 0, chicken.size(), new int[M], 0);
		int ans = 999999;
		for(int[]c : combi) {
			int[] minL = new int[home.size()];
			Arrays.fill(minL,9999);
			for(int a: c) {
				for(int i =0; i<home.size(); i++) {
					minL[i]=Math.min(minL[i], Math.abs(home.get(i)[0]-chicken.get(a)[0])+Math.abs(home.get(i)[1]-chicken.get(a)[1]));
				}
			}
			int sum = 0;
			for(int l: minL)
				sum+=l;
			ans = Math.min(ans, sum);
		}
		
		System.out.println(ans);
	}

	private static void makeCombination(int M, int cnt, int num, int[] selected, int start) {
		if(cnt==M) {
			combi.add(selected.clone());
			return;
		}
		for(int i =start; i<num; i++) {
			selected[cnt]=i;
			makeCombination(M, cnt+1, num, selected, i+1);
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static WorldCup[][] arr = new WorldCup[4][6];
	static int[][] combi = new int[15][2];
	static int idx = 0, ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Boolean[] isAvailable = new Boolean[4];
		for (int r = 0; r < arr.length; r++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int c = 0; c < arr[0].length; c++) {
				int win = Integer.parseInt(st.nextToken());
				int save = Integer.parseInt(st.nextToken());
				int loose = Integer.parseInt(st.nextToken());

				if (win + save + loose == 5) isAvailable[r] = true;
				arr[r][c] = new WorldCup(win, save, loose);
			}
		}
		makeCombination(0, 0, new int[2]);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			ans = 0;
			if (isAvailable[i]) recur(arr[i].clone(), 0);
			sb.append(ans).append(" ");
		}
		System.out.println(sb);
	}

	private static void recur(WorldCup[] ar, int idx) {
		if (idx == combi.length) {
			for (WorldCup w : ar) {
				if (w.win != 0)
					return;
				if (w.save != 0)
					return;
				if (w.loose != 0)
					return;
			}
			ans = 1;
			return;
		}
		int a = combi[idx][0], b = combi[idx][1];
		if (ar[a].win > 0 && ar[b].loose > 0) {
			ar[a].win -= 1;
			ar[b].loose -= 1;
			recur(ar, idx + 1);
			ar[a].win += 1;
			ar[b].loose += 1;
		}
		if (ar[a].save > 0 && ar[b].save > 0) {
			ar[a].save -= 1;
			ar[b].save -= 1;
			recur(ar, idx + 1);
			ar[a].save += 1;
			ar[b].save += 1;
		}
		if (ar[a].loose > 0 && ar[b].win > 0) {
			ar[a].loose -= 1;
			ar[b].win -= 1;
			recur(ar, idx + 1);
			ar[a].loose += 1;
			ar[b].win += 1;
		}
		return;
	}

	private static void makeCombination(int start, int cnt, int[] selected) {
		if (cnt == 2) {
			combi[idx++] = selected.clone();
			return;
		}
		for (int i = start; i < 6; i++) {
			selected[cnt] = i;
			makeCombination(i + 1, cnt + 1, selected);
		}
	}
}

class WorldCup {
	int win = 0;
	int save = 0;
	int loose = 0;

	public WorldCup(int win, int save, int loose) {
		super();
		this.win = win;
		this.save = save;
		this.loose = loose;
	}
}
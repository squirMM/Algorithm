import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution
{
	static int N, M, C, ans;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(in.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			if (M * 2 <= N) {
				lineCombi(0,0,new int[2]);
			}
			combi(0, 0, 0);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void lineCombi(int start, int idx, int[] selected) {
		if (idx == 2) {
			if(selected[1]-selected[0]>=M && selected[1]+M-1<N) {
				for(int i =0; i<N; i++) {
					int tmp = pickup(i,selected[0])+pickup(i,selected[1]);
					ans = Math.max(ans, tmp);
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			selected[idx]=start;
			lineCombi(i+1,idx+1,selected);
		}
	}

	private static void combi(int start, int idx, int sum) {
		if (idx == 2) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int i = start; i < N; i++) {
			int ns = findMax(i);
			combi(i + 1, idx + 1, sum + ns);
		}
	}

	private static int findMax(int idx) {
		int ret = 0;
		// 연속된 꿀을 고름
		for (int i = 0; i <= N - M; i++) {
			// 그중에 최대값을
			ret = Math.max(ret, pickup(idx, i));
		}
		return ret;
	}

	private static int pickup(int idx, int base) {
		int ret = 0;
		for (int j = 1; j < (1 << M); j++) {
			int tmpRet = 0, tmpSum = 0;
			for (int k = 0; k < M; k++) {
				if((j&(1<<k))==0) 
					continue;
				tmpSum += map[idx][base+k];
				if(tmpSum<=C) {
					tmpRet += (int)Math.pow(map[idx][base+k], 2);
				}
			}
			ret = Math.max(ret, tmpRet);
		}
		return ret;
	}
}


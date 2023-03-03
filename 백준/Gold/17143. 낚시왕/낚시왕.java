import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, M;
	static Shark[][] map;
	static PriorityQueue<Shark> pq;
	// direction change : (dir+=2)%4
	static int[] dx = { 0, 0, 1, -1 }, dy = { -1, 1, 0, 0 };

	static class Shark implements Comparable<Shark> {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		public void changeLoc(int r, int c, int d) {
//			System.out.print(this.r + " " + this.c + " " + this.d + " ");
			this.r = r;
			this.c = c;
			this.d = d;
//			System.out.println(r + " " + c + " " + d);
		}

		@Override
		public int compareTo(Shark o) {
			return Integer.compare(o.z, this.z);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Shark[R][C];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			// d-1 해줘야한다.
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			map[r - 1][c - 1] = new Shark(r - 1, c - 1, s, d - 1, z);
		}
		int ans = 0;
		for (int i = 0; i < C; i++) {
			// 상어 잡기
			for (int j = 0; j < R; j++) {
				if (map[j][i] == null)
					continue;
				ans += map[j][i].z;
				map[j][i] = null;
				break;
			}
			map = moveShark();
//			System.out.println();
		}
		System.out.println(ans);
	}

	private static Shark[][] moveShark() {
		Shark[][] tmp = new Shark[R][C];
		pq = new PriorityQueue<>();

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == null)
					continue;
				Shark t = nextLoc(map[r][c]);
				pq.add(t);
			}
		}

		while (!pq.isEmpty()) {
			Shark poll = pq.poll();
			if (tmp[poll.r][poll.c] != null)
				continue;
			tmp[poll.r][poll.c] = poll;
		}
		return tmp;
	}

	private static Shark nextLoc(Shark s) {
		int nr = s.r + dy[s.d] * s.s, nc = s.c + dx[s.d] * s.s, nd = s.d;
		if (nr < 0) {
			if ((Math.abs(nr) / (R - 1)) % 2 == 0) {
				nd = 1;
				nr = dy[nd] * (Math.abs(nr) % (R - 1));
			}
			else if ((Math.abs(nr) / (R - 1)) % 2 == 1) {
				nr = dy[nd] * (Math.abs(nr) % (R - 1)) + (R - 1);
			}
		} else if (nr >= R) {
			if ((Math.abs(nr) / (R - 1)) % 2 == 0) {
				nr = dy[nd] * (nr % (R - 1));
			}
			else if ((Math.abs(nr) / (R - 1)) % 2 == 1) {
				nd = 0;
				nr = dy[nd] * (nr % (R - 1)) + (R - 1);
			}
		}
		if (nc < 0) {
			if ((Math.abs(nc) / (C - 1)) % 2 == 0) {
				nd = 2;
				nc = dx[nd] * (Math.abs(nc) % (C - 1));
			}
			else if ((Math.abs(nc) / (C - 1)) % 2 == 1) {
				nc = dx[nd] * (Math.abs(nc) % (C - 1)) + (C - 1);
			}
		} else if (nc >= C) {
			if ((Math.abs(nc) / (C - 1)) % 2 == 0) {
				nc = dx[nd] * (Math.abs(nc) % (C - 1));
			}
			else if ((Math.abs(nc) / (C - 1)) % 2 == 1) {
				nd = 3;
				nc = dx[nd] * (Math.abs(nc) % (C - 1)) + (C - 1);
			}
		}
		s.changeLoc(nr, nc, nd);
		return s;
	}
}
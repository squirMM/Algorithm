import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		while (N-- > 0) {
			int comm = Integer.parseInt(in.readLine());
			if (comm != 0)
				pq.offer(new int[] { Math.abs(comm), comm });
			else {
				int popNum = pq.size() == 0 ? 0 : pq.poll()[1];
				sb.append(popNum).append("\n");
			}
		}
		System.out.println(sb);
	}
}
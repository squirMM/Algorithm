import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			if (num == 0) {
				if (pq.size() != 0)
					sb.append(pq.poll()).append("\n");
				else
					sb.append(0).append("\n");
			} else
				pq.add(num);
		}
		System.out.println(sb);
	}
}
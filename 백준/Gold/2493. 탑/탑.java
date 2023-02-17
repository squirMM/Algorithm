import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i - 1] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty()) {
				if (arr[i] <= arr[stack.peek()-1]) {
					sb.append(stack.peek()).append(" ");
					break;
				}else {
					stack.pop();
				}
			}
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
			}
			stack.add(i + 1);
		}

		System.out.println(sb.toString());
	}
}
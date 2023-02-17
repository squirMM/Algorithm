import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		
		while(q.size()>1) {
			//1. 버린다.
			q.poll();
			//2. 맨 뒤에 집어 넣는다.
			q.add(q.poll());
		}
		System.out.println(q.poll());
	}
}
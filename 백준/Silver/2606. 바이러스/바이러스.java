import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int ans =0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int L = Integer.parseInt(in.readLine());

		LinkedList<Integer>[] map = new LinkedList[N + 1];

		for (int i = 0; i <= N; i++) {
			map[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a-1].add(b-1);
			map[b-1].add(a-1);
		}
		
		bfs(map,0,N);
		System.out.println(ans);
	}

	private static void bfs(LinkedList<Integer>[] map, int i, int N) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisited = new boolean[N];
		
		q.add(i);
		isVisited[i]=true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			
			Iterator<Integer> iter = map[v].listIterator();
			while(iter.hasNext()) {
				int np = iter.next();
				
				if(isVisited[np])continue;
				isVisited[np]=true;
				q.add(np);
				ans++;
			}	
		}
	}
}
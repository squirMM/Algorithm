import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		LinkedList<Integer>[]map = new LinkedList[N+1];
		for(int i=0; i<N; i++) {
			map[i] = new LinkedList<Integer>();
		}

		for (int r = 0; r < N; r++) {
			String readLine = in.readLine();
			for (int c = r+1; c < N; c++) {
				if(readLine.charAt(c)=='Y') {
					map[r].add(c);
					map[c].add(r);
				}
			}
		}
		int ans =0;
		for(int i =0; i<N; i++) {
			LinkedList<Integer> isVisit =  new LinkedList<Integer>();
			isVisit.addAll(map[i]);
			for(int f: map[i]) {
				for(int ff :map[f]) {
					if(i!=ff && !isVisit.contains(ff)) {
//						System.out.println((i+1)+" "+(f+1)+" "+(ff+1));
						isVisit.add(ff);
					}
				}
				ans =Math.max(isVisit.size(), ans);
			}
		}
		System.out.println(ans);
	}
}
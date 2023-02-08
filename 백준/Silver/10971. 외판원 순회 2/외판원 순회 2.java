import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N = -1; 
	static int[][] map ;
	static boolean[] isVisit;
	static int ans;
	static int start = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		N =  Integer.parseInt(in.readLine());
		StringTokenizer st;
	
		map =  new int[N][N];
		for(int r =0 ; r<N; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c=0; c<N; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		ans = 10_000_000;
		isVisit= new boolean[N];
		
		for(int i=0; i<N; i++) {
			start=i;
			isVisit[i]=true;
			travle(0,1,i);
			isVisit[i]=false;
		}
		System.out.println(ans);
	}

	public static void travle(int total, int cnt, int via ) {
		if(cnt==N) {
			if(map[via][start]!=0) {
				ans =  Math.min(ans,total+map[via][start]);
			}
			return;
		}
		for(int i=0; i<N; i++) {
			if(map[via][i]==0||isVisit[i]) continue;
			isVisit[i]=true;
			travle(total+map[via][i], cnt+1, i);
			isVisit[i]=false;
		}
	}
}
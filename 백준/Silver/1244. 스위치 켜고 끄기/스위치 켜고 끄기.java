import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main   {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		arr = new int[num];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int pNum = Integer.parseInt(in.readLine());
		for (int i = 0; i < pNum; i++) {
			st = new StringTokenizer(in.readLine());
			int pType = Integer.parseInt(st.nextToken());
			int sNum = Integer.parseInt(st.nextToken());
			changeSwitches(pType, sNum);
		}
		printSwitches();
	}
	private static void changeSwitches(int pType, int sNum) {
		if(pType==1) {
			for(int i=sNum-1; i<arr.length; i+=sNum) {
				if(arr[i]==0) arr[i]=1;
				else if(arr[i]==1) arr[i]=0;
			}
		}else {
			if(arr[sNum-1]==0) arr[sNum-1]=1;
			else if(arr[sNum-1]==1) arr[sNum-1]=0;
			girls(sNum-1,1);
		}
	}

	private static void girls(int idx, int range) {
		//범위
		if(idx-range<0 || idx+range>=arr.length) return;
		
		//값 대칭 확인
		if(arr[idx-range]==arr[idx+range] ) {
			if(arr[idx-range]==0) arr[idx+range]=arr[idx-range]=1;
			else if(arr[idx-range]==1) arr[idx-range]=arr[idx+range]=0;
			girls(idx,range+1);
		}else{
			return;
		}
	}
	private static void printSwitches() {
		for (int i = 1; i <= arr.length; i++) {
			System.out.print(arr[i-1] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
	}
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList();
		for (int i = 1; i <= N; i++)
			list.add(i);

		sb.append("<");
		int cnt = 1, idx = 0;;
		while (list.size() > 0) {
			if(idx>=list.size()) idx=0;
			if(cnt==M) { 
				sb.append(list.remove(idx));
				if(list.size()>0)sb.append(",").append(" ");
				cnt=1;
			}else {
				idx++;				
				cnt++;
			}
		}
		sb.append(">");

		System.out.println(sb);
	}
}
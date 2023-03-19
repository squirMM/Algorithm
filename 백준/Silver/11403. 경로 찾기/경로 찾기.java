import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[][] map = new int[N][N];
        for (int r = 0; r < map.length; r++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int c = 0; c < map.length; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k=0; k<N; k++) {
            for(int i =0; i<N; i++){
                for(int j =0; j<N; j++){
                    if(map[i][k]==1 && map[k][j]==1)
                        map[i][j]=1;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map.length; c++) {
                ans.append(map[r][c]).append(" ");
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}
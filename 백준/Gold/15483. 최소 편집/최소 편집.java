import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String A = in.readLine().trim();
        String B = in.readLine().trim();

        int[][] check = new int[A.length() + 1][B.length() + 1];
//      init
        for (int i = 0; i <= A.length(); i++)
            check[i][0] = i;
        for (int j = 0; j <= B.length(); j++)
            check[0][j] = j;

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if(A.charAt(i-1)==B.charAt(j-1))
                    check[i][j] = check[i-1][j-1];
                else{
                    check[i][j] = Math.min(Math.min(check[i][j-1],check[i-1][j]),check[i-1][j-1])+1;
                }
            }
        }

        System.out.println(check[A.length()][B.length()]);
    }
}
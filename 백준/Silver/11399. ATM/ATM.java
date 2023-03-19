import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            ans += arr[i];
        }
        System.out.println(ans);
    }
}
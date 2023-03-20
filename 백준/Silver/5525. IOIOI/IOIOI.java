import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());
        String s = in.readLine();
        int ans = 0;

        while (true) {
            boolean toggle = true;
            int cnt = 0, i;
            for ( i = s.indexOf('I') + 1; i < s.length(); i++) {
                if (s.charAt(i) == 'I' && !toggle) {
                    cnt += 1;
                    toggle = true;
                } else if (s.charAt(i) == 'O' && toggle) {
                    toggle = false;
                } else {
                    ans = cnt >= N ? ans + cnt - N + 1 : ans;
                    s = s.substring(i);
                    break;
                }
            }
            if(i==s.length()) {
                ans = cnt >= N ? ans + cnt - N + 1 : ans;
                break;
            }
        }
        System.out.println(ans);
    }
}
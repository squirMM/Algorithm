import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String S = in.readLine();
        StringBuilder T = new StringBuilder(in.readLine());

        while (T.length() > S.length()) {
            char c = T.charAt(T.length() - 1);
            T.deleteCharAt(T.length() - 1);
            if (c == 'B') T.reverse();
        }
        if (!S.equals(T.toString())) System.out.println(0);
        else System.out.println(1);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int plus = 0;
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                plus += Integer.parseInt(sb.toString());
                sb.setLength(0);
                if (s.charAt(i) == '-') {
                    list.add(plus);
                    plus = 0;
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        plus+=Integer.parseInt(sb.toString());
        list.add(plus);

        int ans = list.get(0);
        for(int i =1; i<list.size(); i++)
            ans-=list.get(i);
        System.out.println(ans);
    }
}
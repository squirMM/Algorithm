import java.util.*;
class Solution {
    public String solution(String[] seoul) {
        for (int i=0; i<seoul.length; i++){
             if (seoul[i].equals("Kim")){
                String num=i+"";
                return "김서방은 "+num+"에 있다";
            }
        }
        return "";
    }
}
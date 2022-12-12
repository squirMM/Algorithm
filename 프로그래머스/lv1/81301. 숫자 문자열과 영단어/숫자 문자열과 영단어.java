import java.util.*;
class Solution {
    public int solution(String s) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};  
        for (int i=0; i<num.length; i++){
            s=s.replaceAll(num[i],i+"");
        }
        
        return Integer.valueOf(s);
    }
}
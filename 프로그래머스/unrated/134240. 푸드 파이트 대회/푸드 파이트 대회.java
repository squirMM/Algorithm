import java.util.Arrays;
class Solution {
     public String solution(int[] food) {
        String ans = "";
        for(int i=1; i<food.length; i++){
            ans+=(i+"").repeat((int)food[i]/2);
        }
        char[] chars = ans.toCharArray();
        Arrays.sort(chars);
         
        ans = String.valueOf(chars)+"0";
        for(int i =chars.length-1; i>-1; i--){
            ans+=chars[i];
        }
        return ans;
    }
}
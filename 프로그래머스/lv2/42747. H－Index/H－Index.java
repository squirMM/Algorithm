import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        for(int i=0; i<citations.length; i++){
            if(citations.length-i <= citations[i]){
                ans = citations.length-i;
                break;
            }
        }
        return ans;
    }
}
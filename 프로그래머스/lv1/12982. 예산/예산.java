import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int cnt=0;
        for (int num : d){
            budget-=num;
            if (budget<0)
                break;
            cnt+=1;
        }
        return cnt;
    }
}
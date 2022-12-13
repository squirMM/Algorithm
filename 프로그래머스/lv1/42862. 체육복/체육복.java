import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
     public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
         
        List<Integer> lo = new ArrayList<>();
        for (int l : lost) lo.add(l);
        List<Integer> rev = new ArrayList<>();
        for (int r : reserve){ 
            if (lo.contains(r)) lo.remove(lo.indexOf(r));
            else rev.add(r);
        }
     
        int ans = n-lo.size();
        int cnt=0;
        while (!rev.isEmpty() && !lo.isEmpty()){
            if (rev.get(0)<lo.get(0)-1){
                rev.remove(0);
            }
            else if (rev.get(0)>lo.get(0)+1){
                lo.remove(0);
            }
            else{
                rev.remove(0);
                lo.remove(0);
                cnt+=1;
            }
        }
        return ans+cnt;
    }
}
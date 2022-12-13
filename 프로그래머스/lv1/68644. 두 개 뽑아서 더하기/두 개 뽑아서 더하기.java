import java.util.*;
class Solution {
  public int[] solution(int[] numbers) {
        List<Integer> sum = new ArrayList();
        for (int idx=0; idx<numbers.length; idx++){
            for (int j=idx+1; j<numbers.length; j++){
                int num = numbers[idx]+numbers[j];
                if (sum.contains(num)) continue;
                sum.add(num);
            }
        }
        int[] ans = new int[sum.size()];
        for (int idx=0; idx<sum.size(); idx++){
            ans[idx]=sum.get(idx);
        }
        Arrays.sort(ans);
        return ans;
    }
}
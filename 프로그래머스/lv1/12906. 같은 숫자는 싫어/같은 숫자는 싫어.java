import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList();
        for (int a: arr){
            if (!list.isEmpty() && list.get(list.size()-1)==a)
                continue;
            list.add(a);
        }
        int[] ans = new int[list.size()];
        for (int idx=0; idx<list.size(); idx++){
            ans[idx]=list.get(idx);
        }
        return ans;
    }
}
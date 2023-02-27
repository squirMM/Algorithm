import java.util.Arrays;
import java.util.Collections;
class Solution {
    public String solution(int[] numbers) {
       String[] nums = new String[numbers.length];
		for (int idx = 0; idx < numbers.length; idx++) 
			nums[idx] = numbers[idx] + "";
        
		Arrays.sort(nums, (o1, o2) -> {
			return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
		});
        
        String ans = String.join("",nums);
        if(ans.charAt(0)=='0') return "0";
		return ans;
    }
}
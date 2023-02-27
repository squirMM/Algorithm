import java.util.Arrays;
import java.util.Collections;
class Solution {
    public String solution(int[] numbers) {
       String[][] nums = new String[numbers.length][];
		for (int idx = 0; idx < numbers.length; idx++) {
			String num = numbers[idx] + "";
			String remNum = num+num+num;
			nums[idx] = new String[] { remNum, num };
		}
		Arrays.sort(nums, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o2[1].length() - o1[1].length();
			}
			return o2[0].compareTo(o1[0]);
		});
		StringBuilder sb = new StringBuilder();
        boolean isZero = true;
		for (String[] num : nums) {
            if(!num[1].equals("0"))isZero=false;
			sb.append(num[1]);
		}
        if(isZero)return "0";
		return sb.toString();
    }
}
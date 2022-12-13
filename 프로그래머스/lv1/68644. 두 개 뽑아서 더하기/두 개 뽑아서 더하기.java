import java.util.*;
class Solution {
  public Integer[] solution(int[] numbers) {
        Set<Integer> sum = new TreeSet();
        for (int idx=0; idx<numbers.length; idx++){
            for (int j=idx+1; j<numbers.length; j++){
                sum.add(numbers[idx]+numbers[j]);
            }
        }
        return sum.toArray(new Integer[0]);
    }
}
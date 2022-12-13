import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        int[] one = new int[]{1, 2, 3, 4, 5};
        int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] thr = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[]hit = new int[3];
        
        for(int idx=0; idx<answers.length; idx++){
            if(one[idx%one.length]==answers[idx]) hit[0]+=1;
            if(two[idx%two.length]==answers[idx]) hit[1]+=1;
            if(thr[idx%thr.length]==answers[idx]) hit[2]+=1;
        }
        
        int max = Math.max(hit[0],Math.max(hit[1],hit[2]));
        List<Integer> answer = new ArrayList();
        if (max==hit[0]) answer.add(1);
        if (max==hit[1]) answer.add(2);
        if (max==hit[2]) answer.add(3);
        
        return answer;
    }
}
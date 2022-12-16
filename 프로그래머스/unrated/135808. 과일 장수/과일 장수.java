import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int ans=0;
        Arrays.sort(score);
        int idx=score.length-1;
        while (idx>-1){
            if (idx-m+1 >=0)
                ans+=score[idx-m+1]*m;
            idx-=m;
        }
        return ans;
    }
}
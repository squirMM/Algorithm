import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int ans=0;
        Arrays.sort(score);
        for (int idx=score.length; idx>=m; idx-=m){
            ans+=score[idx-m]*m;
        }
        return ans;
    }
}
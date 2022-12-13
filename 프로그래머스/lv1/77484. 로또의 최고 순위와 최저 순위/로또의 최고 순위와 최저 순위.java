import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> win = new ArrayList<>();
        for(int w : win_nums) win.add(w);
        
        int hit=0;
        int re=0;
        for(int l : lottos){
            if (l==0) re+=1;
            if (win.contains(l))
                hit+=1;
        }
        int max=7-(re+hit)>6?6:7-(re+hit);
        int min=7-(hit)>6 ? 6 : 7-(hit);
        return new int[]{max,min};
    }
}
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution {
public int solution(int[][] board, int[] moves) {
        int[][] pose = new int[board.length][board[0].length];
        for (int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++)
                pose[j][i]=board[i][j];
        }
        int answer = 0;
        List<Integer> stack = new ArrayList<>();
        for (int m : moves){
            while (pose[m-1].length>0 && pose[m-1][0]==0){
                pose[m-1]=Arrays.copyOfRange(pose[m-1],1,pose[m-1].length);
            }
            if (pose[m-1].length==0) continue;
            if (!stack.isEmpty() && stack.get(stack.size()-1)==pose[m-1][0]) {
                stack.remove(stack.size()-1);
                answer+=2;
            }
            else stack.add(pose[m-1][0]);
            pose[m-1]=Arrays.copyOfRange(pose[m-1],1,pose[m-1].length);
        }
        return answer;
    }
}
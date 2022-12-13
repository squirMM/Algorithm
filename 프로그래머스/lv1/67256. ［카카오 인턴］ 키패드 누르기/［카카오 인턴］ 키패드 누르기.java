class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] pos = new int[]{12,10};
        for (int n : numbers){
            if (n==2 || n==5 || n==8 || n==0){
                if (n==0) n=11;
                int r = cal(pos[0],n);
                int l = cal(pos[1],n);
                if (r>l){
                    answer+="L";
                    pos[1]=n;
                }
                else if(r<l){
                    answer+="R";
                    pos[0]=n;
                }
                else{
                    if (hand.equals("left")) {
                        answer+="L";
                        pos[1]=n;
                    }
                    else{
                        answer+="R";
                        pos[0]=n;
                    }
                }
            }
            else{
                pos[n%3]=n;
                if (n%3==0) answer+="R";
                else answer+="L";
            }
        }
        return answer;
    }
    public int cal(int hand , int num){
        int row = Math.abs((int)(hand-1)/3-(int)(num-1)/3);
        int col = Math.abs((hand-1)%3 - (num-1)%3);
        return row+col;
    }
}
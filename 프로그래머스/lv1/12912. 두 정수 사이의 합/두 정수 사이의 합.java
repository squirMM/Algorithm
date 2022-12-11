class Solution {
    public long solution(int a, int b) {
        if (a>b){
            int c=a; a=b; b=c;
        }
        long answer = 0;
        for (int i = a; i<=b; i++){
            answer+=i;
        }
        return answer;
    }
}
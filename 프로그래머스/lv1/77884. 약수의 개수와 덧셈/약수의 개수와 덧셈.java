class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int num=left; num<=right; num++){
            int cnt=0;
            for (int i=1; i<=(int)Math.sqrt(num); i++){
                if (num%i!=0) continue;
                if (i==Math.sqrt(num)) cnt-=1;
                cnt+=2;
            }
            if (cnt%2==0) answer+=num;
            else answer-=num;
        }
        return answer;
    }
}
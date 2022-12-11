class Solution {
    public int solution(int n) {
        int sum=0;
        for (int i =1; i<(int)Math.sqrt(n)+1; i++){
            if (n%i!=0) continue;
            if (i!=Math.sqrt(n)) sum+=i;
            sum+=(int)n/i;
        }
        return sum;
    }
}
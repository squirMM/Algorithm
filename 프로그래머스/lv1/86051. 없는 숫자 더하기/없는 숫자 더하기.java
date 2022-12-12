class Solution {
    public int solution(int[] numbers) {
        int maxTotal = 45;
        int sum = 0;
        for (int n: numbers){
            sum+=n;
        }
        return maxTotal-sum;
    }
}
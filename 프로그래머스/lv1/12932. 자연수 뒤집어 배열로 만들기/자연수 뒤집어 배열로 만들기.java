class Solution {
   public static int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer= new int[s.length()];
        for(int i =s.length() ; i>0; i--){
            answer[s.length()-i]=s.charAt(i-1)-'0';
        }
        return answer;
    }
}
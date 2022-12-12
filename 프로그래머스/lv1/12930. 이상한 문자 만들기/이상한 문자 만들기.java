class Solution {
    public String solution(String s) {
        String[] arr = s.split("");
        String answer = "";
        int cnt = 0;
        for (String ss : arr){
            cnt = ss.equals(" ")? 0 :cnt+1;
            answer += cnt%2!=0 ? ss.toUpperCase():ss.toLowerCase();
        }
        return answer;
    }
}
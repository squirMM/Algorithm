class Solution {
    public String solution(String s) {
        int midIdx = (int)s.length()/2;
        
        if (s.length()%2==0)
            return s.substring(midIdx-1,midIdx+1);       
        
        return s.substring(midIdx,midIdx+1);
    }
}
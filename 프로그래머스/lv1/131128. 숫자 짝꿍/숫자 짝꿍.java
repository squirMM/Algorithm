import java.util.Arrays;
class Solution {
    public String solution(String X, String Y) {
        char[] xChars = X.toCharArray();
        Arrays.sort(xChars);
        char[] yChars = Y.toCharArray();
        Arrays.sort(yChars);
        
        return ret(xChars, yChars);
    }
    public String ret(char[] a, char[] b){
        StringBuilder answer = new StringBuilder();
        int aIdx=a.length-1;
        int bIdx=b.length-1;

        while (aIdx>-1 && bIdx>-1){
            if(a[aIdx]==b[bIdx]){
                answer.append(a[aIdx]);
                aIdx-=1;
                bIdx-=1;
            }
            else if(a[aIdx]>b[bIdx])
                aIdx-=1;
            else if(a[aIdx]<b[bIdx])
                bIdx-=1;
        }
        
        if (answer.toString().equals(""))
            return "-1";
        else if (answer.toString().startsWith("0")) 
            return "0";
        return answer.toString();
    }
}
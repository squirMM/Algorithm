class Solution {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++){
            int num = (int)chars[i]+n;
            if ('a'<=chars[i] && chars[i]<='z'&& num>122) num-=26;
            else if('A'<=chars[i] && chars[i]<='Z'&& num>90) num-=26;
            chars[i]=chars[i]==' '?chars[i]: (char)num;
        }
        return String.valueOf(chars);
    }
}
class Solution {
    boolean solution(String s) {
        int cnt=0;
        s=s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i)=='p'){
                cnt+=1;
            }
            if (s.charAt(i)=='y'){
                cnt-=1;
            }
        }

        if(cnt==0){return true;}
        return false;
    }
}
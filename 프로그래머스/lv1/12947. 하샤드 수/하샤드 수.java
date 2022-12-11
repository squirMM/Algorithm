class Solution {
    public boolean solution(int x) {
        int num=0;
        int newX=x;
        while (newX>0){
            num+=newX%10;
            newX/=10;
        }
        return x%num==0;
    }
}
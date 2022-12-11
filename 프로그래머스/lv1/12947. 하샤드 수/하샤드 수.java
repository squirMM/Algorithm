class Solution {
    public boolean solution(int x) {
        int num = String.valueOf(x+"").chars().map(ch->ch-'0').sum();
        return x%num==0;
    }
}
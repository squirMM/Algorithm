class Solution {
    public long solution(int price, int money, int count) {
        long needM = (long)price*count*(count+1)/2;
        return needM>money? needM-money: 0;
    }
}
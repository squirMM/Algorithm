class Solution {
    public boolean solution(String s) {
        return isNumeric(s) && (s.length()==4 || s.length()==6);
    }
    public boolean isNumeric(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
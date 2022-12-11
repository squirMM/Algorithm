class Solution {
    public String solution(String pn) {
        String mask="*";
        return mask.repeat(pn.length()-4)+pn.substring(pn.length()-4);
    }
}
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[n];
        
        for (int idx=0; idx<n; idx++)
            ans[idx]=Integer.toBinaryString(arr1[idx]|arr2[idx]);
        
        for (int idx=0; idx<n; idx++){
            if (ans[idx].length()<n)
                ans[idx]="0".repeat(n-ans[idx].length())+ans[idx];
            ans[idx]=ans[idx].replaceAll("0"," ");
            ans[idx]=ans[idx].replaceAll("1","#");
        }
        return ans;
    }
}
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[arr1.length];
        
        for (int idx=0; idx<arr1.length; idx++){
            String bin1=Integer.toBinaryString(arr1[idx]);
            String bin2=Integer.toBinaryString(arr2[idx]);
            
            bin1="0".repeat(n-bin1.length())+bin1;
            bin2="0".repeat(n-bin2.length())+bin2;
        
            // System.out.println(bin1+" "+bin2);
            ans[idx]="";
            for (int i=0; i<bin1.length() ; i++)
                ans[idx]+= bin1.charAt(i)=='0'&& bin2.charAt(i)=='0'? " ":"#";
        }
        return ans;
    }
}
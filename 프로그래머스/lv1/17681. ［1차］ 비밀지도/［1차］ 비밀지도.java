class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[arr1.length];
        
        int max1=0;
        for (int a : arr1) max1=Math.max(Integer.toBinaryString(a).length(),max1);
        int max2=0;
        for (int a : arr2) max2=Math.max(Integer.toBinaryString(a).length(),max2);
        
        int maxSize=Math.max(max1,max2);
        
        for (int idx=0; idx<arr1.length; idx++){
            String bin1=Integer.toBinaryString(arr1[idx]);
            String bin2=Integer.toBinaryString(arr2[idx]);
            
            bin1="0".repeat(maxSize-bin1.length())+bin1;
            bin2="0".repeat(maxSize-bin2.length())+bin2;
        
            // System.out.println(bin1+" "+bin2);
            ans[idx]="";
            for (int i=0; i<bin1.length() ; i++)
                ans[idx]+= bin1.charAt(i)=='0'&& bin2.charAt(i)=='0'? " ":"#";
        }
        return ans;
    }
}
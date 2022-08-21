class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1,i=digits.length-1;
        while(i>=0 && carry==1){
            digits[i]+=carry;
            carry=digits[i]/10;
            digits[i]%=10;
            i--;
        }
        if(carry==0)
            return digits;
        else{
            //creating new array of size n+1
            int[] ans=new int[digits.length+1];
            ans[0]=carry;
            for(int j=1;j<ans.length;j++){
                ans[j]=digits[j-1];
            }
            return ans;
        }
    }
}
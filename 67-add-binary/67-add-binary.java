class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1, j=b.length()-1, carry=0;
        String ans="";
        while(i>=0 && j>=0){
            int sum=(a.charAt(i)-'0')+(b.charAt(j)-'0')+carry;
            ans=String.valueOf(sum%2)+ans;
            carry=sum/2;
            i--;
            j--;
        }
        if(i==-1){
            while(j>=0){
                int sum=b.charAt(j)-'0'+carry;
                ans=String.valueOf(sum%2)+ans;
                carry=sum/2;
                j--;
            }
        }
        else if(j==-1){
            while(i>=0){
                int sum=a.charAt(i)-'0'+carry;
                ans=String.valueOf(sum%2)+ans;
                carry=sum/2;
                i--;
            }
        }
        if(carry>0)
            ans=String.valueOf(carry)+ans;
        return ans;
    }
}
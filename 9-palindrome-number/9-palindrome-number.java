class Solution {
    public int findReverse(int x){
        int ans=0;
        while(x>0){
            ans = (ans*10) + (x%10);
            x=x/10;
        }
        return ans;
    }
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int reverse=findReverse(x);
        if(reverse==x)
            return true;
        else
            return false;
    }
}
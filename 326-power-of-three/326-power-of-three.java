class Solution {
    public boolean isPowerOfThree(int n) {
        double x=Math.log10(n)/Math.log10(3);
        if(x-(int)x==0)
            return true;
        else
            return false;
    }
}
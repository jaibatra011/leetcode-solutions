class Solution {
    public int missingNumber(int[] nums) {
        int sum1=(nums.length+1)*(0+nums.length)/2; //sum=n(a+l)/2
        int sum2=0;
        for(int i:nums)
            sum2+=i;
        return sum1-sum2;
    }
}
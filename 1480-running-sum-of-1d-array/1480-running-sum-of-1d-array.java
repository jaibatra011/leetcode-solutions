class Solution {
    public int[] runningSum(int[] nums) {
        int prev=0;
        for(int i=0;i<nums.length;i++){
            nums[i]+=prev;
            prev=nums[i];
        }
        return nums;
    }
}
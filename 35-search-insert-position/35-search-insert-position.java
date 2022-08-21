class Solution {
    public int searchInsert(int[] nums, int target) {
        //BINARY SEARCH
        int i=0, r=nums.length, l=0;
        if(target<=nums[0])
            return 0;
        if(target>nums[nums.length-1])
            return nums.length;
        while(true){
            if(nums[i]>target && nums[i-1]<target)
                break;
            i=(r+l)/2;
            if(nums[i]>target){
                r=i;
            }
            else if(nums[i]<target){
                l=i+1;
            }
            else
                return i;
            System.out.println(i);
        }
        return i;
    }
}
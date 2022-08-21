class Solution {
    public int removeDuplicates(int[] nums) {
        int ans=1, j=1; // nums atleast has 1 element
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){ // check with previous element
                //each element is checked twice, once with the prev one and another with next one when current becomes previous
                ans++; //no. of non duplicate elements 
                nums[j++]=nums[i];// takes the first occurence and place it in array
                //j keeps position of where new non dulicate element can be placed
            }
        }
        return ans;
    }
}
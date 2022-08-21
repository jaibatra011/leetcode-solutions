class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0, j=nums.length-1; //j has position of number to be put in place of val
        for(int i=nums.length-1;i>=0;i--){
            while(j>0 && nums[j]==val){
                // finding number which can replace val
                j--;
            }
            if(nums[i]==val){ // finding position of val
                count++;
                if(i<j){    //we dont need to remove right side elements 
                    //replace the ith element with jth element and find next position for j
                    nums[i]=nums[j--];
                }
            }
        }
        return nums.length-count;
    }
}
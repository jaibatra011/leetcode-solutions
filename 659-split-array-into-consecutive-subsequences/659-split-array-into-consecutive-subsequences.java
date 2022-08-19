class Solution {
    public int findBestSubsequence(int num, int[] count, int[] end){
        int ans=count.length;
        int bestCount=Integer.MAX_VALUE;
        for(int j=0;j<count.length;j++){ //finding first best option
            if(end[j]==Integer.MIN_VALUE || num==end[j]+1){
                ans=j;
                bestCount=count[j];
                break;
            }
        }
        for(int j=0;j<count.length;j++){ //finding if better option is available
            if(num==end[j]+1 && count[j]<bestCount){
                ans=j;
                bestCount=count[j];
            }
        }
        return ans;
    }
    public boolean isPossible(int[] nums) {
        if(nums.length<3)
            return false;
        int[] count=new int[nums.length/3];//maximum no. of subsequences of min length 3
        int[] end=new int[nums.length/3];
        for(int i=0;i<end.length;i++){
            end[i]=Integer.MIN_VALUE;
        }
        for(int i=0;i<nums.length;i++){
            int j=findBestSubsequence(nums[i], count, end);
            if(j==count.length) // number can not be placed in any subsequence
                    return false;
            end[j]=nums[i]; //update end of subsequence
            count[j]++; // and increment count
        }
        for(int i=0;i<count.length;i++){
            if(count[i]!=0 && count[i]<3){
                return false; //if any subsequence has less than 3 numbers
            }
        }
        return true;
    }
}
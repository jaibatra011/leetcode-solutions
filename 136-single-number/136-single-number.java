class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i:nums) //XOR of all numbers will return single number
            ans^=i;
        return ans;
    }
}
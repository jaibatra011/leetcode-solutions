class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE, maxSum=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            maxSum=Math.max(maxSum, prices[i]-min);
        }
        return maxSum;
    }
}

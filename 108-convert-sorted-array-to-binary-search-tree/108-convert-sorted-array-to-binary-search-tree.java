/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayListtoBST(int[] nums,int i, int j){
        if(j<i)
            return null;
        int mid = i + ((j-i)/2);
        TreeNode left = sortedArrayListtoBST(nums, i, mid-1);
        TreeNode right = sortedArrayListtoBST(nums, mid+1,j);
        return new TreeNode(nums[mid],left,right);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayListtoBST(nums, 0, nums.length-1);
    }
}
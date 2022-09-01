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
    public int goodNodesHelper(TreeNode root,int max){
        if(root==null)
            return 0;
        if(root.val>=max){
            max=root.val;
            return goodNodesHelper(root.left,max)+goodNodesHelper(root.right,max)+1;
        }
        return goodNodesHelper(root.left,max)+goodNodesHelper(root.right,max);
    }
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root,Integer.MIN_VALUE);
    }
}
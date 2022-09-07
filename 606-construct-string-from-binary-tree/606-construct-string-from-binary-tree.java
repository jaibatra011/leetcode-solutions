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
    public String tree2str(TreeNode root) {
        if(root==null)
            return "";
        String left=tree2str(root.left);
        String right=tree2str(root.right);
        
        //if right is not empty string, we don't care what left has, we need to add () to left
        if(right!="") 
            return root.val+"("+left+")"+"("+right+")";
        
        //if it comes till here, means right is empty string, we don't need to add () to right
        if(left!="") 
            return root.val+"("+left+")";
        
        //last case, both left and right is returned empty string, no () needed
        return Integer.toString(root.val);
    }
}
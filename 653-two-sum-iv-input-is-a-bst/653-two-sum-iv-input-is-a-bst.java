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
    public boolean findTargetHelper(TreeNode root, int k, Set<Integer> s){
        if(root==null)
            return false;
        if(s.contains(k-root.val))
            return true;
        s.add(root.val);
        return findTargetHelper(root.left,k,s) || findTargetHelper(root.right,k,s);
    }
    public boolean findTarget(TreeNode root, int k) {
        return findTargetHelper(root,k,new HashSet<Integer>());
    }
}
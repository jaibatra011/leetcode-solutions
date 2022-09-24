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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return new ArrayList<>();
        if(root.left==null && root.right==null){
            if(root.val==targetSum){
                List<List<Integer>> ans = new ArrayList<>();
                List<Integer> a1 = new ArrayList<>();
                a1.add(root.val);
                ans.add(a1);
                return ans;
            }
            else
                return new ArrayList<>();
        }
        List<List<Integer>> ans=pathSum(root.left,targetSum-root.val);
        ans.addAll(pathSum(root.right,targetSum-root.val));
        for(List<Integer> l:ans){
            l.add(0,root.val);
        }
        return ans;
    }
}
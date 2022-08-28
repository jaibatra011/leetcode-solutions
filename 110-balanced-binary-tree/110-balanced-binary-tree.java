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
class Pair{
    boolean ans;
    int height;
    
    public Pair(){
        ans=true;
        height=0;
    }
}
class Solution {
    public Pair isBalancedAndGetHeight(TreeNode root){
        if(root==null)
            return new Pair();
        Pair p1=isBalancedAndGetHeight(root.left);
        Pair p2=isBalancedAndGetHeight(root.right);
        if(p1.ans && p2.ans){
            if(p1.height-p2.height<-1 || p1.height-p2.height>1){
                p1.ans=false;
                return p1;
            }
            else{
                if(p1.height>p2.height){
                    p1.height+=1;
                    return p1;
                }
                else{
                    p2.height+=1;
                    return p2;
                }
            }
        }
        if(p1.ans)
            return p2;
        else
            return p1;
    }
    public boolean isBalanced(TreeNode root) {
        return isBalancedAndGetHeight(root).ans;
    }
}
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
    boolean ans; //isBalanced
    int height;
    
    public Pair(){ //constructor for null case
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
        if(p1.ans && p2.ans){ //iff both left and right are true
            if(p1.height-p2.height<-1 || p1.height-p2.height>1){ // if height diff > 1
                p1.ans=false; //return false, height doesn't matter
                return p1;
            }
            else{ //if height diff < 1, find max height , add 1 and return ans
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
        if(p1.ans) // if left is true, right must be false hence return false
            return p2;
        else
            return p1; // else either right is false or both are false, hence return false
    }
    public boolean isBalanced(TreeNode root) {
        //Calling helper function which returns Pair,boolean isBalanced(ans) and int height
        return isBalancedAndGetHeight(root).ans;
    }
}
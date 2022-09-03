/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair{
    TreeNode ans;
    boolean isPresent;
    
    public Pair(){
        ans=null;
        isPresent=false;
    }
}
class Solution {
    public Pair lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return new Pair();
        if(root.val==p.val || root.val==q.val){
            Pair p1 = new Pair();
            p1.ans=root;
            p1.isPresent=true;
            return p1;
        }
        Pair p1=lowestCommonAncestorHelper(root.left,p,q);
        Pair p2=lowestCommonAncestorHelper(root.right,p,q);
        if(p1.isPresent && p2.isPresent){
            Pair pAns = new Pair();
            pAns.ans=root;
            pAns.isPresent=true;
            return pAns;
        }
        if(p1.isPresent)
            return p1;
        if(p2.isPresent)
            return p2;
        return new Pair();
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorHelper(root,p,q).ans;
    }
}
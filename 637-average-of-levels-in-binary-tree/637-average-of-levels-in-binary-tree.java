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
    long sum;
    int count;
    
    public Pair(){
        sum=0;
        count=0;
    }
}
class Solution {
    public void averageOfLevelsHelper(List<Pair> list, int level, TreeNode root){
        if(root==null)
            return;
        if(list.size()<=level)
            list.add(level,new Pair());
        Pair p=list.get(level);
        p.sum+=root.val;
        p.count++;
        list.set(level, p);
        averageOfLevelsHelper(list, level+1, root.left);
        averageOfLevelsHelper(list, level+1, root.right);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        //DFS (4ms,47.3MB) O(N) O(N)
        List<Pair> list = new ArrayList<>();
        averageOfLevelsHelper(list,0,root);
        List<Double> ans=new ArrayList<>();
        for(Pair p:list){
            ans.add(p.sum*1.0/p.count);
        }
        return ans;
        //BFS (2ms,43.6MB) O(N) O(N)
        /*List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            long sum=0;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            ans.add((sum*1.0)/size);
        }
        return ans;*/
    }
}
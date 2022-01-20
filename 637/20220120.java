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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Double> list=new ArrayList<>();
        if(root==null) return list;
        q.offer(root);
        while(q.size()>0){
            double ans=0.0;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode tmp=q.poll();
                ans+=tmp.val;
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
            }
            list.add(ans/size);
        }
        return list;
    }
}
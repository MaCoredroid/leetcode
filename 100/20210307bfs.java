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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while(!queue1.isEmpty()&&!queue2.isEmpty()){
            TreeNode node1=queue1.poll();
            TreeNode node2=queue2.poll();
            if(node1==null&&node2==null){
                continue;
            }else if(node1==null||node2==null){
                return false;
            }else{
                if(node1.val!=node2.val){
                    return false;
                }
                queue1.offer(node1.left);
                queue1.offer(node1.right);
                queue2.offer(node2.left);
                queue2.offer(node2.right);
            }
        }
        if(!queue1.isEmpty()||!queue2.isEmpty()){
            return false;
        }
        return true;

    }
}
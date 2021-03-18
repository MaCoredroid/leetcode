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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        Queue<TreeNode> node=new LinkedList<>();
        Queue<Integer> value=new LinkedList<>();
        node.offer(root);
        value.offer(root.val);
        while(!node.isEmpty()){
            TreeNode temp=node.poll();
            int sum=value.poll();
            if(temp.left==null&&temp.right==null){
                if(sum==targetSum){
                    return true;
                }else{
                    continue;
                }
            }
            if(temp.left!=null){
                node.offer(temp.left);
                value.offer(sum+temp.left.val);
            }
            if(temp.right!=null){
                node.offer(temp.right);
                value.offer(sum+temp.right.val);
            }
        }
        return false;
    }
}
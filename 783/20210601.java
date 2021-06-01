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
    int ans=Integer.MAX_VALUE;
    int pre=-1;
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return ans;
    }

    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        if(pre!=-1){
            ans=Math.min(ans,root.val-pre);
        }
        pre=root.val;
        helper(root.right);
    }
}
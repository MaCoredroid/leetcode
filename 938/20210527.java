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
    int ans=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root,low,high);
        return ans;
    }

    private void helper(TreeNode root, int left, int right){
        if(root==null){
            return;
        }
        if(root.val>=left&&root.val<=right){
            ans+=root.val;
            helper(root.left,left,right);
            helper(root.right,left,right);
        }else if(left>root.val){
            helper(root.right,left,right);
        }else if(right<root.val){
            helper(root.left,left,right);
        }
    }
}
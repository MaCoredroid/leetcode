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
    public int closestValue(TreeNode root, double target) {
        ans=root.val;
        helper(root,target);
        return ans;
    }
    
    public void helper(TreeNode root, double target){
        if(root==null) return;
        if(Math.abs(root.val-target)<Math.abs(ans-target)){
            ans=root.val;
        }
        helper(root.left,target);
        helper(root.right,target);
    }
}
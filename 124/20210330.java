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
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int val1=helper(root.left);
        int val2=helper(root.right);
        if(val1<0){
            val1=0;
        }
        if(val2<0){
            val2=0;
        }
        ans=Math.max(ans,val1+val2+root.val);
        return Math.max(val1+root.val,val2+root.val);

    }
}
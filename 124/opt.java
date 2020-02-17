/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ret=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ret;
    }
    public int helper(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left_gain=Math.max(0,helper(root.left));
        int right_gain=Math.max(0,helper(root.right));
        ret=Math.max(left_gain+right_gain+root.val,ret);
        return Math.max(left_gain,right_gain)+root.val;
    }
}
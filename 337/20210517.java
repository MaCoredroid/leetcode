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
    public int rob(TreeNode root) {
        int[] ans=helper(root);
        return Math.max(ans[0],ans[1]);
    }

    private int[] helper(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] left=helper(root.left);
        int[] right=helper(root.right);
        int[] ans=new int[2];
        ans[0]=Math.max(left[1],left[0])+Math.max(right[0],right[1]);
        ans[1]=root.val+left[0]+right[0];
        return ans;
    }
}
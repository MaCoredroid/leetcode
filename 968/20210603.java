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
    public int minCameraCover(TreeNode root) {
        return helper(root)[1];
    }

    public int[] helper(TreeNode root){
        if(root==null){
            return new int[]{Integer.MAX_VALUE/2,0,0};
        }
        int[] left=helper(root.left);
        int[] right=helper(root.right);
        int a=left[2]+right[2]+1;
        int b=Math.min(a,Math.min(left[0]+right[1],left[1]+right[0]));
        int c=Math.min(a,right[1]+left[1]);
        return new int[]{a,b,c};
    }
}
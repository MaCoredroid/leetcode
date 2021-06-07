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
    public int findTilt(TreeNode root) {
        return helper(root)[1];
    }

    private int[] helper(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] l=helper(root.left);
        int[] r=helper(root.right);
        return new int[]{root.val+l[0]+r[0],Math.abs(l[0]-r[0])+l[1]+r[1]};
    }
}
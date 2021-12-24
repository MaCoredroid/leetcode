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
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode left=root.left;
        flatten(root.left);
        TreeNode right=root.right;
        flatten(root.right);
        if(left!=null){
            root.right=left;
            while(left.right!=null){
                left=left.right;
            }
            left.right=right;
        }
        root.left=null;
    }
}
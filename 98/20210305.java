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
    
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return verify(Long.MAX_VALUE,Long.MIN_VALUE,root);
        

    }

    public boolean verify(long max,long min,TreeNode root){
        if(root==null){
            return true;
        }
        if(root.val<max&&root.val>min){
            return verify(root.val,min,root.left)&&verify(max,root.val,root.right);
        }
        return false;

    }
    
}
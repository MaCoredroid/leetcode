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
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    private boolean helper(TreeNode root,Integer left,Integer right){
        if(root==null){
            return true;
        }
        if(left!=null&&root.val<=left){
            return false;
        }
        if(right!=null&&root.val>=right){
            return false;
        }
        return helper(root.left,left,root.val)&&helper(root.right,root.val,right);
        
    }
}
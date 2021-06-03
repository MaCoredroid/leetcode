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
    public TreeNode convertBiNode(TreeNode root) {
        return helper(root,null);
    }

    private TreeNode helper(TreeNode root, TreeNode ans){
        if(root==null){
            return ans;
        }
        root.right=helper(root.right,ans);
        TreeNode ret=helper(root.left,root);
        root.left=null;
        return ret;
    }
}
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
    TreeNode ret=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p.val,q.val);
        return ret;
    }

    private boolean helper(TreeNode root,int p,int q){
        if(root==null){
            return false;
        }
        boolean flag1=helper(root.left,p,q);
        boolean flag2=helper(root.right,p,q);
        if(flag1&&flag2){
            ret=root;
            return true;
        }
        if(root.val==p||root.val==q){
            if(flag1||flag2){
                ret=root;
            }
            return true;
        }
        return flag1||flag2;
    }
}
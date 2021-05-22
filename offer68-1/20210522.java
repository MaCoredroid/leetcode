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
    TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p.val,q.val);
        return ans;
    }

    private boolean helper(TreeNode root,int p,int q){
        if(root==null){
            return false;
        }
        boolean flag1=helper(root.left,p,q);
        boolean flag2=helper(root.right,p,q);
        if(root.val==p||root.val==q){
            if(flag1||flag2){
                ans=root;
            }
        }else{
            if(flag1&&flag2){
                ans=root;
            }
        }
        return flag1||flag2||root.val==p||root.val==q;
    }
}
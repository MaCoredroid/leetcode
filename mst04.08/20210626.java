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
    TreeNode node=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p.val,q.val);
        return node;
    }

    private boolean helper(TreeNode root,int p,int q){
        if(root==null){
            return false;
        }
        if(root.val==p||root.val==q){
            if(helper(root.left,p,q)||helper(root.right,p,q)){
                node=root;
            }
            return true;
        }else{
            boolean flag1=helper(root.left,p,q);
            boolean flag2=helper(root.right,p,q);
            if(flag1&&flag2){
                node=root;
            }
            return flag1||flag2;
        }
    }
}
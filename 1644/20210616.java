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
        if(root.val==p||root.val==q){
            if(helper(root.left,p,q)||helper(root.right,p,q)){
                ans=root;
            }
            return true;
        }else{
            boolean flag1=helper(root.left,p,q);
            boolean flag2=helper(root.right,p,q);
            if(flag1&&flag2){
                ans=root;
                return true;
            }else if(flag1||flag2){
                return true;
            }else{
                return false;
            }
        }
    }
}
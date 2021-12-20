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
    
    
    public boolean helper(TreeNode root,int p,int q){
        if(root==null){
            return false;
        }
        boolean l=helper(root.left,p,q);
        boolean r=helper(root.right,p,q);
        if(root.val==p||root.val==q){
            if(l||r){
                ans=root;
            }
            return true;
        }
        if(l&&r) ans=root;
        return l||r;
    }
}
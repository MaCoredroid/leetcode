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
    private TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p.val,q.val);
        return ans;
    }

    private boolean dfs(TreeNode root, int p,int q){
        if(root==null){
            return false;
        }
        boolean left=dfs(root.left,p,q);
        boolean right=dfs(root.right,p,q);
        if((left&&right)||((root.val==p||root.val==q)&&(left||right))){
            ans=root;
        }
        return left||right||root.val==p||root.val==q;
    }
}
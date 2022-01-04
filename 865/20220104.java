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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    
    public Result dfs(TreeNode root){
        if(root==null) return new Result(null,0);
        Result l=dfs(root.left),r=dfs(root.right);
        if(l.len>r.len) return new Result(l.node,l.len+1);
        if(r.len>l.len) return new Result(r.node,r.len+1);
        return new Result(root,l.len+1);
    }
}

class Result{
    TreeNode node;
    int len;
    public Result(TreeNode node,int len){
        this.node=node;
        this.len=len;
    }
}
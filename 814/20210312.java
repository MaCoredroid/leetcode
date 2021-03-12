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
    public TreeNode pruneTree(TreeNode root) {
        if(dfs(root)){
            root=null;
        }
        return root;
    }

    private boolean dfs(TreeNode root){
        if(root==null){
            return true;
        }
        boolean flag1=true;
        boolean flag2=true;
        if(dfs(root.left)){
            root.left=null;
        }else{
            flag1=false;
        }
        if(dfs(root.right)){
            root.right=null;
        }else{
            flag2=false;
        }
        if(root.val==0&&flag1&&flag2){
            return true;
        }
        return false;
    }
}
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
    int ret=0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        dfs(root,0);
        return ret;
    }
    
    public void dfs(TreeNode root,int val){
        int ans=val*10+root.val;
        if(root.left==null&&root.right==null){
            ret+=ans;
            return;
        }
        if(root.left!=null) dfs(root.left,ans);
        if(root.right!=null) dfs(root.right,ans);
    }
}
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
    int ans=0;
    public int longestConsecutive(TreeNode root) {
        dfs(root,null,0);
        return ans;
    }
    
    public void dfs(TreeNode root,TreeNode prev,int len){
        if(root==null) return;
        len=(prev==null||prev.val==root.val-1)?len+1:1;
        dfs(root.left,root,len);
        dfs(root.right,root,len);
        ans=Math.max(ans,len);
    }
}
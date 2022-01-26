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
    TreeNode ret=null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root,1);
        return ret;
        
        
    }
    
    int dfs(TreeNode root,int val){
        ans=Math.max(ans,val);
        if(root==null) return val;
        int val1=dfs(root.left,val+1);
        int val2=dfs(root.right,val+1);
        int res= Math.max(val1,val2);
        if(val1==ans&&val2==ans){
            ret=root;
        }
        return res;        
    }
    
}
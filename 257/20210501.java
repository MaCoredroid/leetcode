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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        dfs(ans,root,"");
        return ans;
    }

    private void dfs(List<String> ans,TreeNode root,String s){
        if(root==null){
            return;
        }
        s+=Integer.toString(root.val);
        if(root.left==null&&root.right==null){
            ans.add(s);
        }else{
            s+="->";
            dfs(ans,root.left,s);
            dfs(ans,root.right,s);
        }
    }
}
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        dfs(ans,0,root);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int depth,TreeNode root){
        if(root==null){
            return;
        }
        if(ans.size()==depth){
            ans.add(new ArrayList<>());
        }
        ans.get(depth).add(root.val);
        dfs(ans,depth+1,root.left);
        dfs(ans,depth+1,root.right);
    }
}
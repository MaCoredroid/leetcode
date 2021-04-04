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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        helper(ans,0,root);
        return ans;
    }

    private void helper(List<Integer> ans,int depth,TreeNode root){
        if(root==null){
            return;
        }
        if(ans.size()==depth){
            ans.add(root.val);
        }
        helper(ans,depth+1,root.right);
        helper(ans,depth+1,root.left);
    }
}
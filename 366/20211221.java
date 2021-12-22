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
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        helper(root);
        return ans;
    }
    
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=helper(root.left);
        int r=helper(root.right);
        int depth=Math.max(l,r);
        if(ans.size()==depth){
            ans.add(new ArrayList<>());
        }
        ans.get(depth).add(root.val);
        return depth+1;
    }
}
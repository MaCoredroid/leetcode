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
    List<Integer> ans=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,0);
        return ans;
    }
    
    private void helper(TreeNode root, int index){
        if(root==null){
            return;
        }
        if(index==ans.size()){
            ans.add(root.val);
        }
        helper(root.right,index+1);
        helper(root.left,index+1);
    }
}
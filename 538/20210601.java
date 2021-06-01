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
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        modify(root);
        return root;
    }

    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        ans+=root.val;
        helper(root.left);
        helper(root.right);
    }

    private void modify(TreeNode root){
        if(root==null){
            return;
        }
        modify(root.left);
        int temp=root.val;
        root.val=ans;
        ans-=temp;
        modify(root.right);
    }
}
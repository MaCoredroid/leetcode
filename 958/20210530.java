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
    int size=0,maxCode=0;
    public boolean isCompleteTree(TreeNode root) {
        helper(root,1);
        return size==maxCode;
    }

    public void helper(TreeNode node,int code){
        if(node==null){
            return;
        }
        size++;
        maxCode=Math.max(maxCode,code);
        helper(node.left,code*2);
        helper(node.right,code*2+1);
    }
}
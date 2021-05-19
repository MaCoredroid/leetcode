/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;
    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int num1=helper(root.left);
        int num2=helper(root.right);
        if(num1==-1||num2==-1){
            return -1;
        }
        if(Math.abs(num1-num2)>1){
            return -1;
        }
        return Math.max(num1,num2)+1;
    }
}
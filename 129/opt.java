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
    int ans=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return ans;
    }
    public void helper(TreeNode root,int value)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null&&root.right==null)
        {
            ans+=value*10+root.val;
            return;
        }
        helper(root.left,value*10+root.val);
        helper(root.right,value*10+root.val);
    }
}
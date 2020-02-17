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
    public int minDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        return postOrder(root);
    }
    public int postOrder(TreeNode root)
    {
        if(root.left==null&&root.right==null)
        {
            return 1;
        }
        if(root.left==null)
        {
            return postOrder(root.right)+1;
        }
        if(root.right==null)
        {
            return postOrder(root.left)+1;
        }
        return Math.min(postOrder(root.left),postOrder(root.right))+1;
    }
}
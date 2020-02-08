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
    public boolean isValidBST(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return postOrder(root,null,null);
    }
    public boolean postOrder(TreeNode root,Integer top,Integer bottom)
    {
        if(root==null)
        {
            return true;
        }
        if((top!=null&&root.val>=top)||(bottom!=null&&root.val<=bottom))
        {
            return false;
        }
        return postOrder(root.left,root.val,bottom)&&postOrder(root.right,top,root.val);
    }
}
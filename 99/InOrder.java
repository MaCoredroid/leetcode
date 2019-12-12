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
    TreeNode first= null;
    TreeNode second = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inOrderTraversal(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inOrderTraversal(root.left);
        if(pre!=null&&root.val<pre.val)
        {
            if(first==null)
            {
                first=pre;
                second=root;
            }
            else
            {
                second=root;
            }
        }
        pre=root;
        inOrderTraversal(root.right);
        
    }
}
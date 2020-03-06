import javax.swing.tree.TreeNode;

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
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)
        {
            return root;
        }
        TreeNode copy=new TreeNode(root.val);
        copy.right=mirrorTree(root.left);
        copy.left=mirrorTree(root.right);
        return copy;
    }
}
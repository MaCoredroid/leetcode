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
    List<Integer> output=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return output;
    }
    public void inOrder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inOrder(root.left);
        output.add(root.val);
        inOrder(root.right);
    }
}
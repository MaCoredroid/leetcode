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
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int ans1=maxDepth(root.left)+1;
        int ans2=maxDepth(root.right)+1;
        return ans1>ans2?ans1:ans2;
    }
}
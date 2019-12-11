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
    public int minCameraCover(TreeNode root) {
        int ret = bfs(root);
        if(ret == -1)
        {
            ans++;
        }
        return ans;
    }
    public int bfs(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=bfs(root.left);
        int right=bfs(root.right);
        if(left == -1 || right == -1)
        {
            ans++;
            return 1;
        }
        if(left == 0 && right == 0)
        {
            return -1;
        }
        if(left == 1 || right ==1)
        {
            return 0;
        }
        return -1;
    }
}
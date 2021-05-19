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
    int cnt=0;
    int ans=0;
    public int kthLargest(TreeNode root, int k) {
        cnt=k-1;
        helper(root);
        return ans;
    }

    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.right);
        if(cnt==-1){
            return;
        }
        if(cnt==0){
            cnt=-1;
            ans=root.val;
            return;
        }
        cnt--;
        helper(root.left);
    }
}
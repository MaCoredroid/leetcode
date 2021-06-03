/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return ans>=1?ans-1:0;
    }

    private int[] helper(TreeNode root){
        if(root==null){
            return new int[]{-1,0};
        }
        int[] left=helper(root.left);
        int[] right=helper(root.right);
        int leftlen=0,rightlen=0;
        if(left[0]==root.val){
            leftlen=left[1];
        }
        if(right[0]==root.val){
            rightlen=right[1];
        }
        int res=1+leftlen+rightlen;
        ans=Math.max(res,ans);
        return new int[]{root.val,Math.max(1+leftlen,1+rightlen)};
    }
}
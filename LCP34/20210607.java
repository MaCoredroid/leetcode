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
    public int maxValue(TreeNode root, int k) {
        int[] ret=helper(root,k);
        int ans=Integer.MIN_VALUE;
        for(int val:ret){
            ans=Math.max(ans,val);
        }
        return ans;
    }

    private int[] helper(TreeNode root, int k){
        int[] dp=new int[k+1];
        if(root==null){
            return dp;
        }
        int[] l=helper(root.left,k);
        int[] r=helper(root.right,k);
        int maxl=Integer.MIN_VALUE;
        for(int val:l){
            maxl=Math.max(maxl,val);
        }
        int maxr=Integer.MIN_VALUE;
        for(int val:r){
            maxr=Math.max(maxr,val);
        }
        dp[0]=maxl+maxr;
        for(int i=1;i<=k;i++){
            for(int j=0;j<i;j++){
                dp[i]=Math.max(dp[i],l[j]+root.val+r[i-1-j]);
            }
        }
        return dp;
    }
}
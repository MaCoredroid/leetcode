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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int ans=nums[left];
        int index=left;
        for(int i=left+1;i<=right;i++){
            if(nums[i]>ans){
                ans=nums[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(ans);
        root.left=helper(nums,left,index-1);
        root.right=helper(nums,index+1,right);
        return root;
    }
}
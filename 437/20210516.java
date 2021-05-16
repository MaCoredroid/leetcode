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
    int counter=0;
    public int pathSum(TreeNode root, int targetSum) {
        helper(root,targetSum,new int[0]);
        return counter;
    }

    private void helper(TreeNode root,int targetSum,int[] candidates){
        if(root==null){
            return;
        }
        int[] ans=new int[candidates.length+1];
        for(int i=0;i<candidates.length;i++){
            if(root.val+candidates[i]==targetSum){
                counter++;
            }
            ans[i]=root.val+candidates[i];
        }
        ans[ans.length-1]=root.val;
        if(root.val==targetSum){
            counter++;
        }
        helper(root.left,targetSum,ans);
        helper(root.right,targetSum,ans);
    }
}
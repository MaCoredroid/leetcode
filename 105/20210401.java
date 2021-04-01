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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);

    }

    private TreeNode helper(int[] preorder,int[] inorder,int left1,int right1,int left2,int right2){
        if(left1>right1){
            return null;
        }
        if(left1==right1){
            return new TreeNode(preorder[left1]);
        }
        int head=preorder[left1];
        TreeNode ans=new TreeNode(head);
        int i=left2;
        while(i<=right2){
            
            if(inorder[i]==head){
                break;
            }else{
                i++;
            }
        }

        ans.left=helper(preorder,inorder,left1+1,left1+i-left2,left2,i-1);
        ans.right=helper(preorder,inorder,right1-right2+i+1,right1,i+1,right2);
        return ans;
    }

    
}
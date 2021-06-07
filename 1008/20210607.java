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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }

    private TreeNode helper(int[] preorder,int left,int right){
        if(left==right){
            return new TreeNode(preorder[left]);
        }
        if(left>right){
            return null;
        }
        TreeNode root=new TreeNode(preorder[left]);
        int p=left+1;
        while(p<=right&&preorder[p]<preorder[left]){
            p++;
        }
        root.left=helper(preorder,left+1,p-1);
        root.right=helper(preorder,p,right);
        return root;
    }
}
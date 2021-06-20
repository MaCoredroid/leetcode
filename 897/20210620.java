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
    public TreeNode increasingBST(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left==null){
            if(root.right!=null){
                root.right=increasingBST(root.right);
            }
            return root;
        }
        TreeNode left=increasingBST(root.left);
        root.left=null;
        TreeNode p=left;
        while(p.right!=null){
            p=p.right;
        }
        p.right=root;
        if(root.right!=null){
            root.right=increasingBST(root.right);
        }
        return left;
    }

    
}
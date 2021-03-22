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
    public int successor(TreeNode root){
        TreeNode right=root.right;
        while(right.left!=null){
            right=right.left;
        }
        return right.val;
    }

    public int predecessor(TreeNode root){
        TreeNode left=root.left;
        while(left.right!=null){
            left=left.right;
        }
        return left.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(key<root.val){
            root.left=deleteNode(root.left,key);
        }else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }else{
            if(root.left==null&&root.right==null){
                root=null;
            }else if(root.left!=null){
                root.val=predecessor(root);
                root.left=deleteNode(root.left,root.val);
            }else{
                root.val=successor(root);
                root.right=deleteNode(root.right,root.val);
            }
        }
        return root;
    }

}